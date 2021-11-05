package com.ervin.EZSpring.WebEntrance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
@RequestMapping("/mail")

public class MailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/send")
    public void sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("xx@163.com");
        message.setTo("yy@163.com");
        message.setSubject("it is a test for spring boot");
        message.setText("发送邮件。");
        try {
            mailSender.send(message);
            logger.info("邮件已发送。");
        } catch (Exception e) {
            logger.error("发送邮件时发生异常了！", e);
        }
    }

    @RequestMapping("/send2")
    public void sendMail2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("xx@163.com");
        helper.setTo("yy@163.com");
        helper.setSubject("主题：发送有附件的邮件");
        helper.setText("发送一封有附件的邮件。");
        FileSystemResource file1 = new FileSystemResource(new File("d:\\xx.jpg"));
        FileSystemResource file2 = new FileSystemResource(new File("d:\\yy.jpg"));
        helper.addAttachment("附件-1.jpg", file1);
        helper.addAttachment("附件-2.jpg", file2);
        try {
            mailSender.send(mimeMessage);
            logger.info("带附件的邮件已发送。");
        } catch (Exception e) {
            logger.error("带附件邮件时发生异常了！", e);
        }
    }

}
