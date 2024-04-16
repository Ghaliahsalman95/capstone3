package com.example.capstone3.DTO;

import com.example.capstone3.Model.Case;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@Data
public class AppealDTO {
    @NotNull(message = "cant null caseID")
    private Integer case_Id;
    @NotEmpty(message = "title appeal can not be null")
    private String title;
    @NotEmpty(message = "description appeal can not be null")
    private String description;
    private LocalDate startDate;

}
