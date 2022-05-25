package com.coursework.fireProtectionSystems.repository;

import com.coursework.fireProtectionSystems.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    void deleteUsersById(Long id);
    Users findByUsername(String username);
    Users findUsersById(Long id);
}
