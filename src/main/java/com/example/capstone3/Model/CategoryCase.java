package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoryCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name appeal can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @OneToOne
    @MapsId//only oneToOne relation its =    @PrimaryKeyJoinColumn
    @JsonIgnore // infinite loop so when get case ignore case
    // في البوستمان مايطلع اوبجكت cases
    private Case casse;

    @ManyToOne
    // i can remove it because it's will auto generated
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    // في البوستمان مايطلع اوبجكت user
    private User user;

}
