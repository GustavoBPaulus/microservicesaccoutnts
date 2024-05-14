package com.gm2.dev.accountservice.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "account_number",nullable = false, unique = true)
    private String accountNumber;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(name = "full_name",nullable = false, unique = true, length = 100)
    private String fullName;
    @Column(nullable = false)
    private boolean enable;

}
