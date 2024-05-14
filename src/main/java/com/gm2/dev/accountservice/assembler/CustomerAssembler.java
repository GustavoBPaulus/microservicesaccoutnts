package com.gm2.dev.accountservice.assembler;

import com.gm2.dev.accountservice.dto.CustomerDto;
import com.gm2.dev.accountservice.entity.Customer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CustomerAssembler {
    private final ModelMapper modelMapper;

    public Customer toEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto, Customer.class);
    }

    public CustomerDto toDto(Customer customer) {
        return  modelMapper.map(customer, CustomerDto.class);
    }
}
