package com.awbeci.util;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


/**
 * 发送邮件服务类
 * Created by zhangwei on 2015/7/5.
 */
public class Email {

    private String host;

    private String fromEmail;

    private String userName;

    private String password;
    MyProperties myProperties = new MyProperties();

    public Email(String  properties) {
        Properties prop = myProperties.getPropertiesByName(properties);
        this.userName = prop.getProperty("email");
        this.password = prop.getProperty("pwd");
        setHost(prop.getProperty("host"));
        setFromEmail(prop.getProperty("fromEmail"));
    }

    /**
     * 发送邮件
     *
     * @param toEmail 发送邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * @throws Exception
     */
    public boolean sendEmail(String toEmail, String subject, String content) {

        try {
            JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

            //设定mail server
            senderImpl.setHost(getHost());

            //建立邮件消息,发送简单邮件和html邮件的区别
            MimeMessage mailMessage = senderImpl.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, "utf-8");

            //设置收件人，寄件人
            messageHelper.setTo(toEmail);
            messageHelper.setFrom(getFromEmail());
            messageHelper.setSubject(subject);
            //true 表示启动HTML格式的邮件
            messageHelper.setText(content, true);

            senderImpl.setUsername(getUserName()); // 根据自己的情况,设置username
            senderImpl.setPassword(getPassword()); // 根据自己的情况, 设置password
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
            prop.put("mail.smtp.timeout", "25000");
            senderImpl.setJavaMailProperties(prop);

            //发送邮件
            senderImpl.send(mailMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}