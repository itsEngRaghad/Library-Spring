package com.example.springbookdbexcersise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = "name can't be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;

    @NotEmpty(message = "username can't be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String username;

    @Column(columnDefinition = "varchar(15) not null")
    @NotNull(message = "password can't be null")
    @Pattern(regexp = "^[a-zA-Z]\\w{3,14}$")
//    The password's first character must be a letter, it must contain at least 4 characters
//    and no more than 15 characters and no characters other than letters, numbers
//    the underscore may be used
//Matches : abcd | aBc45DSD_sdf | password
    private String password;

    @Email //unique
    @NotEmpty(message = "email can't be empty")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String email;


}
