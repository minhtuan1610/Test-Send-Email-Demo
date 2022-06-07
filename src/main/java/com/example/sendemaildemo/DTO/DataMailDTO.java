package com.example.sendemaildemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

// Mô tả email gồm những gì
@Data   // Use Lombok
@AllArgsConstructor // Use Lombok
@NoArgsConstructor  // Use Lombok
public class DataMailDTO {
    private String to;
    private String subject;
    private String content;
    private Map<String, Object> props;
}
