package com.test;

import com.javamail;
import com.orm.Mail;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Test5 {

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.setHost("smtp.sina.com.cn");
        mail.setSender("accountnum@sina.cn");
        mail.setReceiver("1252575758@qq.com");
        mail.setUsername("accountnum@sina.cn");
        mail.setPassword("tangtaiming123");
        mail.setSubject("xiaotaiming1");
        mail.setMessage("bbbbbbbbbbbbbb1");
        javamail javamail = new javamail();
        javamail.send(mail);
    }

}
