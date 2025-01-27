package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appeal {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //
//-----------------------------Relational-------------------------------
    @OneToOne
    @MapsId//only oneToOne relation its =    @PrimaryKeyJoinColumn
    @JsonIgnore // infinite loop so when get case ignore case
    private Case cas;

    //-------------------------------------------------
    @NotEmpty(message = "title appeal can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String title;
    @NotEmpty(message = "description appeal can not be null")
    @Column(columnDefinition = "varchar(255) not null")
    private String description;
    @Column(columnDefinition = "date not null")
    private LocalDate startDate;


}
