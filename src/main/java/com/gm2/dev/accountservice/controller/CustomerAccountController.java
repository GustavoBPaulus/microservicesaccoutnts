package com.gm2.dev.accountservice.controller;

import com.gm2.dev.accountservice.dto.CustomerDto;
import com.gm2.dev.accountservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/customer-account")
public class CustomerAccountController {
    private final CustomerService service;

    @PostMapping
    public ResponseEntity post(@RequestBody CustomerDto customerDto){
        try {
            CustomerDto newCustomer = service.save(customerDto);
            return new ResponseEntity(newCustomer, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
