package com.example.capstone3.DTO;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@Data
public class CategoreDTO {

    @NotNull(message = "cant null case ID")
    private Integer case_Id;

    @NotNull(message = "cant null user ID")
    private Integer user_Id;
    @NotEmpty(message = "cant null name")
    private String name;


}
