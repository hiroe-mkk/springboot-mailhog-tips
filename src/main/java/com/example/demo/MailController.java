package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail/send")
public class MailController {

    private final EmailSenderClient emailSenderClient;

    public MailController(EmailSenderClient emailSenderClient) {
        this.emailSenderClient = emailSenderClient;
    }

    @PostMapping
    public void sendMail(@RequestParam String from) {
        emailSenderClient.sendMail(from);
    }
}
