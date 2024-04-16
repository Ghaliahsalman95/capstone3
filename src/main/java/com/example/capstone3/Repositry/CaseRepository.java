package com.example.capstone3.Repositry;

import com.example.capstone3.Model.Case;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Integer> {

    Case findCaseById(Integer id);

}
