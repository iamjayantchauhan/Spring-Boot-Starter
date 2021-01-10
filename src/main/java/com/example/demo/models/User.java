package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document("users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userID;
    private String firstName;
    private String lastName;

    private String mobileNumber;

    @NotBlank(message = "Email address should not be blank")
    @Email(message = "Email should be valid")
    private String emailAddress;

    @NotBlank(message = "Password should not be blank")
    @Size(max = 40)
    private String username;

    @NotBlank
    @Size(max = 256)
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();
}
