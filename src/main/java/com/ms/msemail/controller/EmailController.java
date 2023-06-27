package com.ms.msemail.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.msemail.DTO.EmailDTO;
import com.ms.msemail.model.EmailModel;
import com.ms.msemail.service.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {
 
    @Autowired
    private EmailService service;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO dto) {
        EmailModel model = new EmailModel();
        BeanUtils.copyProperties(dto, model);
        service.sendEmail(model);
        return new ResponseEntity<EmailModel>(model, HttpStatus.CREATED);
    }
}
