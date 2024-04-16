package com.example.capstone3.Repositry;

import com.example.capstone3.Model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealRepository extends JpaRepository<Appeal,Integer> {
    Appeal findAppealByCas_Id(Integer id);
}
