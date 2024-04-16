package com.example.capstone3.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "user name can't be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "email can't be empty!")
    @Email
    private String email;

    @NotNull(message = "years of experience can't be null!")
    @Column(columnDefinition = "int not null")
    private Integer yearsOfExperience;

    @NotEmpty(message = "specialty can't be empty!")
    @Column(columnDefinition = "varchar(20) not null ")
    private String specialty;

    @NotEmpty(message = "role can't be empty!")
    @Pattern(regexp = "^Lawyer|Admin$")
    @Column(columnDefinition = "varchar(7) not null check(role='Lawyer' or role='Admin')")
    private String role;


//====================Relations====================================
    //relation here is many users have many clients!(ManyToMany)
    @ManyToMany(mappedBy = "user")
    private Set<Client> client;
    //delete comment sign later!

    //also 1 user has many cases! (OneToMany)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Case> aCase;
    //check the case name !


    //also 1 user has many tasks! (OneToMany)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Task> tasks;

    //also 1 user has many categories! (OneToMany)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<CategoryCase> categories;
//================================================================

}
