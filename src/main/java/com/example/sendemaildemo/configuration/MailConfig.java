package com.example.sendemaildemo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    // Đọc thông tin từ file application.properties
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private Integer port;
    @Value("${spring.mail.username}")
    private String email;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.properties.mail.smtp.ssl.enable}")
    private String isSSL;

    // Tạo đối tượng JavaMailSender dựa trên thông tin đọc được
    // Đối tượng này dùng để gửi mail đi
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(email);
        mailSender.setPassword(password);
        mailSender.setDefaultEncoding("UTF-8");

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.enable", isSSL);
        properties.put("mail.smtp.from", email);
        properties.put("mail.debug", "true");

        return mailSender;
    }
}
