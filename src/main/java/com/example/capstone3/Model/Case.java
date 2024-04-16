package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    //---------------Relational-----------------------
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "cas")
    @PrimaryKeyJoinColumn// هذا تابع
    private Appeal appeal;//done
    //---------------------------------------------------------
    @ManyToOne
    @JsonIgnore
    private User user;
    //-------------------------------------------------------------
    @OneToOne(cascade = CascadeType.PERSIST,mappedBy = "cas")
    @PrimaryKeyJoinColumn
    private Document document;

    //-------------------------------------------------------------
    @ManyToOne
    @JsonIgnore
    private Client clients;
    //-------------------------------------------------------------
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "casse")
    @PrimaryKeyJoinColumn// هذا تابع
    private CategoryCase gategoryCases;
    //------------------------------------------
    @AssertTrue
    private boolean isAppeal;
    //  @Column(columnDefinition = "datetime ")
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@FutureOrPresent
    private LocalDate startDate;


}
