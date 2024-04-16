package com.example.capstone3.Repositry;

import com.example.capstone3.Model.User;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);
}
