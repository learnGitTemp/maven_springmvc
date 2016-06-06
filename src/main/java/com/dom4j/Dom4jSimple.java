package com.dom4j;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/5/1.
 */
public class Dom4jSimple {

    public static void main(String[] args) {
        //获取文件
        File path = new File(".");
        String xml = StringUtils.removeEnd(path.getAbsolutePath(), ".") + "src\\main\\resources\\demo.xml";
        System.out.println(xml);
        path = new File(xml);

        //获取文件xml信息
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(path);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element root = doc.getRootElement();

        Element meiShiMoKuai = root.element("mei.shi.mo.kuai");

        //遍历某节点下的所有节点
        Iterator it = meiShiMoKuai.elementIterator();

        while(it.hasNext()) {
            Element node = (Element) it.next();
            System.out.println(node.getName());
        }
    }

}
