package com.example.sendemaildemo.service.impl;

import com.example.sendemaildemo.DTO.DataMailDTO;
import com.example.sendemaildemo.DTO.sdi.ClientSdi;
import com.example.sendemaildemo.service.ClientService;
import com.example.sendemaildemo.service.MailService;
import com.example.sendemaildemo.utils.Const;
import com.example.sendemaildemo.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    MailService mailService;

    @Override
    public Boolean create(ClientSdi sdi) {
        //  Xử lý nghiệp vụ trước khi tạo thông tin người dùng
        try {
            DataMailDTO dataMail = new DataMailDTO();

            dataMail.setTo(sdi.getEmail());
            dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);

            Map<String, Object> props = new HashMap<>();
            props.put("name", sdi.getName());
            props.put("username", sdi.getUsername());
            props.put("password", DataUtils.generateTempPwd(6));
            dataMail.setProps(props);

            mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);
            return true;
        } catch (MessagingException exp) {
            exp.printStackTrace();
        }
        return false;
    }
}
