package com.coursework.fireProtectionSystems.service;

import com.coursework.fireProtectionSystems.model.CheckUser;
import com.coursework.fireProtectionSystems.model.UserSystem;
import com.coursework.fireProtectionSystems.model.Users;
import com.coursework.fireProtectionSystems.repository.UserRepository;
import com.coursework.fireProtectionSystems.repository.UserSystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserSystemRepo userSystemRepo;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, UserSystemRepo userSystemRepo) {
        this.userRepository = userRepository;
        this.userSystemRepo = userSystemRepo;
    }


    public Boolean checkLogin(Users user) {
        Users checkUser = userRepository.findByUsername(user.getUsername());
        return (checkUser != null) && (checkUser.getPassword().equals(user.getPassword()));
    }

    public Boolean checkUsername(CheckUser user) {
        Users checkUser = userRepository.findByUsername(user.getUsername());
        return (checkUser == null);
    }

    public Users registration(Users user) {
        user.setRole("USER");
        return userRepository.save(user);
    }

    public Boolean checkRole(CheckUser user) {
        Users checkUser = userRepository.findByUsername(user.getUsername());
        return checkUser.getRole().equals("ADMIN");
    }

    public void saveUser(Users newUser, Long id) {
        UserSystem userSystem = new UserSystem();
        userSystem.setIdProtectionSystem(id);
        userSystem.setId(newUser.getId());
        userSystemRepo.save(userSystem);
    }
}
