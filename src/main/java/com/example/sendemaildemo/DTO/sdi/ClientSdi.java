package com.example.sendemaildemo.DTO.sdi;

import lombok.Data;

//  Mô phỏng thông tin người dùng truyền vào
@Data
public class ClientSdi {
    private String name;
    private String username;
    private String email;
}
