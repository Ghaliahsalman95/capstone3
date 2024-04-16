package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Document {
    @Id
    private Integer id;
    @NotEmpty(message = "the title cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String title;
    @NotEmpty(message = "the description cannot be empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String description;
    @NotEmpty(message = "the file path cannot be empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String filePath;

    //---------------------------RELATION --------------------------------------------------
    @OneToOne
    @MapsId
    @JsonIgnore
    private Case cas;
    //-------------------------------------------------------------------------
}