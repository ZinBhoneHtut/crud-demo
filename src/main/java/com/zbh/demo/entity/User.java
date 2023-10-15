package com.zbh.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_profile")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private String address;

    public User(String name, String email, String phoneNumber, GenderEnum gender, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
    }
}
