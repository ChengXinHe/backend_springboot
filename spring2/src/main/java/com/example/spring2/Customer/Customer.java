package com.example.spring2.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
    private Long id;
    @NotBlank(message = "name not be empty")
    private String name;

    @Email
    private String email;
    @NotBlank(message = "password not be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    // 因为有@AllArgsConstructor，所以可以删掉。
//    public Customer(Long Id, String Name, String email, String password) {
//        this.id = Id;
//        this.name = Name;
//        this.email = email;
//        this.password = password;
//    }


    @JsonProperty("customerId")
    Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

}