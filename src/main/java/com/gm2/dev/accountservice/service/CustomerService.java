package com.gm2.dev.accountservice.service;

import com.gm2.dev.accountservice.assembler.CustomerAssembler;
import com.gm2.dev.accountservice.dto.CustomerDto;
import com.gm2.dev.accountservice.dto.CustomerResponseDto;
import com.gm2.dev.accountservice.entity.Customer;
import com.gm2.dev.accountservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerAssembler customerAssembler;

    private final Random random = new Random();
    private final int upperBound = 9;


    @Transactional
    public CustomerResponseDto save(CustomerDto customerDto){
        Customer customer = customerAssembler.toEntity(customerDto);
        customer.setEnable(true);
        customer.setAccountNumber(getAccountNumber());

           return  customerAssembler.toDto(customerRepository.save(customer));
    }
    
    private String getAccountNumber(){
        String account = "";
        for(int i = 0; i < 6; i ++){
            account += random.nextInt(upperBound);
        }
        return  account;
    }
}
