package com.test;

import com.javamail;
import com.orm.Mail;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Test5 {

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.setHost("smtp.sina.com");
        mail.setSender("accountnum@sina.cn");
        mail.setReceiver("accountnum@sina.cn");
        mail.setUsername("accountnum@sina.cn");
        mail.setPassword("tangtaiming123");
        mail.setSubject("xiaotaiming");
        mail.setMessage("bbbbbbbbbbbbbb");
        javamail javamail = new javamail();
        javamail.send(mail);
    }

}
