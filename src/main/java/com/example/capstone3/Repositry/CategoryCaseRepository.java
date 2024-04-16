package com.example.capstone3.Repositry;

import com.example.capstone3.Model.CategoryCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryCaseRepository extends JpaRepository<CategoryCase,Integer> {

    CategoryCase findCategoryCaseById(Integer id);
}
