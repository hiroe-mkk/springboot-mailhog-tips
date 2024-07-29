package com.example.demo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderClient {
    private final JavaMailSender javaMailSender;  // 1. JavaMailSender の準備

    @Autowired
    public EmailSenderClient(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String emailAddress) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();  // 2. MimeMessage の作成

        try {
            // 3. MimeMessageHelper を使用して MIME メッセージを構成
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom("me@mail.com");
            helper.setTo(emailAddress);
            helper.setSubject("件名");
            helper.setText("<html><body><h3>テストメール</h3>本文</body></html>", true);  // 第二引数に true を指定することで、Content-Type が text/html になる

            javaMailSender.send(mimeMessage);  // 4. メールの送信
        } catch (MessagingException | MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
