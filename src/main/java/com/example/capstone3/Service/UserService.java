package com.example.capstone3.Service;

import com.example.capstone3.API.APIException;
import com.example.capstone3.Model.User;
import com.example.capstone3.Repositry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user){
        User u = userRepository.findUserById(id);
        if (u == null){
            throw new APIException("user not found!");
        }
        u.setEmail(user.getEmail());
        u.setName(user.getName());
        u.setTasks(user.getTasks());
        u.setYearsOfExperience(user.getYearsOfExperience());
        u.setSpecialty(user.getSpecialty());
        u.setRole(user.getRole());
        userRepository.save(u);
    }

    public void deleteUser(Integer id){
        User user = userRepository.findUserById(id);
        if (user == null){
            throw new APIException("user not found!");
        }
        userRepository.delete(user);
    }
}
