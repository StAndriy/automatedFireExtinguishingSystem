package com.coursework.fireProtectionSystems.service;

import com.coursework.fireProtectionSystems.model.UserSystem;
import com.coursework.fireProtectionSystems.model.Users;
import com.coursework.fireProtectionSystems.repository.UserRepository;
import com.coursework.fireProtectionSystems.repository.UserSystemRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserSystemService {

    private final UserRepository userRepository;

    private final UserSystemRepo userSystemRepo;

    public UserSystemService(UserSystemRepo userSystemRepo, UserRepository userRepository) {
        this.userSystemRepo = userSystemRepo;
        this.userRepository = userRepository;
    }


    public UserSystem getUserSystem(String username) {
        Users user = userRepository.findByUsername(username);
        if (user == null)
            return null;
        return userSystemRepo.findUserSystemById(user.getId());
    }

    public UserSystem updateUserSystem(UserSystem userSystems) {
        return userSystemRepo.save(userSystems);
    }

    public Users updateUserName(Users user) {
        Users userCurrent = userRepository.findUsersById(user.getId());
        userCurrent.setUsername(user.getUsername());
        return userRepository.save(userCurrent);
    }

    public Users getUser(Long id) {
        return userRepository.findUsersById(id);
    }

    public void deleteAccount(Long id) {
        userSystemRepo.deleteUserSystemById(id);
        userRepository.deleteUsersById(id);

    }
}
