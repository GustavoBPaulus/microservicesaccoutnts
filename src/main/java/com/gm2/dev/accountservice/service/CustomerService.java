package com.gm2.dev.accountservice.service;

import com.gm2.dev.accountservice.assembler.CustomerAssembler;
import com.gm2.dev.accountservice.dto.CustomerDto;
import com.gm2.dev.accountservice.entity.Customer;
import com.gm2.dev.accountservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerAssembler customerAssembler;


    @Transactional
    public CustomerDto save(CustomerDto customerDto){
        Customer customer = customerAssembler.toEntity(customerDto);
        customer.setEnable(true);
        customer.setAccountNumber("1234");

           return  customerAssembler.toDto(customerRepository.save(customer));
    }
}
