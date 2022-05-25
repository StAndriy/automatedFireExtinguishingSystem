package com.coursework.fireProtectionSystems.repository;

import com.coursework.fireProtectionSystems.model.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSystemRepo extends JpaRepository<UserSystem, Long> {
    void deleteUserSystemById(Long id);
    UserSystem findUserSystemById(Long id);
}
