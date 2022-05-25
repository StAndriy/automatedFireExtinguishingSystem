package com.coursework.fireProtectionSystems.repository;

import com.coursework.fireProtectionSystems.model.ProtectionSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProtectionSystemRepo extends JpaRepository<ProtectionSystem, Long> {

    void deleteProtectionSystemById(Long id);
    Optional<ProtectionSystem> findProtectionSystemById(Long id);
}
