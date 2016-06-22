package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/12.
 */
public class ComplieClassLoad extends ClassLoader {

    private byte[] getBytes(String fileName) {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int)len];
        try (FileInputStream fin = new FileInputStream(file)){
            int r = fin.read(raw);
            if (r != len) {
                throw new IOException("无法读取全部文件:" + r + " != " + len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return raw;
    }

    private boolean complie(String javaFile) throws IOException {
        System.out.println("正在编译:" + javaFile + "...");
        Process p = Runtime.getRuntime().exec("javac " + javaFile);
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int ret = p.exitValue();
        return ret == 0;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class classzz = null;
        String fileSub = name.replace(".", "/");
        String javaFileName = fileSub + ".java";
        String classFileName = fileSub + ".class";
        File javaFile = new File(javaFileName);
        File classFile = new File(classFileName);

        if (javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())) {
            try {
                if (!complie(javaFileName) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException ： " + javaFileName);
                }

                if (classFile.exists()) {
                    byte[] raw = getBytes(classFileName);
                    classzz = defineClass(name, raw, 0, raw.length);
                }

                if (classzz == null) {
                    throw new ClassNotFoundException(name);
                }

                return classzz;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return super.findClass(name);

    }
}
