package com;

import com.orm.Mail;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/7/26.
 */
public class javamail {

    private Logger logger = Logger.getLogger(javamail.class);

    public boolean send(Mail mail) {
        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(mail.getHost());
            email.setCharset(Mail.encoding);
            email.addTo(mail.getReceiver());
            email.setFrom(mail.getSender(), mail.getName());
            email.setAuthentication(mail.getUsername(), mail.getPassword());
            email.setSubject(mail.getSubject());
            email.setMsg(mail.getMessage());
            email.send();
            if (logger.isDebugEnabled()) {
                logger.debug(mail.getSender() + "发送邮件." + mail.getReceiver());
            }
        } catch (Exception e) {
            logger.info("失败.");
        }
        return false;
    }

}
