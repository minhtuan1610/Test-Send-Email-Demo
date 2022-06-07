package com.example.sendemaildemo.controller;

import com.example.sendemaildemo.DTO.sdi.ClientSdi;
import com.example.sendemaildemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping(value = "create")
    public ResponseEntity<Boolean> create(@RequestBody ClientSdi sdi) {
        return ResponseEntity.ok(clientService.create(sdi));
    }
}
