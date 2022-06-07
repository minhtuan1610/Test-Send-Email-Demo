package com.example.sendemaildemo.service;

import com.example.sendemaildemo.DTO.DataMailDTO;

import javax.mail.MessagingException;

public interface MailService {
    void sendHtmlMail(DataMailDTO dataMailDTO, String templateName) throws MessagingException;
}
