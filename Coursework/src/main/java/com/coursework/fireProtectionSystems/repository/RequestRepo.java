package com.coursework.fireProtectionSystems.repository;

import com.coursework.fireProtectionSystems.model.ProtectionSystem;
import com.coursework.fireProtectionSystems.model.RequestOnAct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepo extends JpaRepository<RequestOnAct, Long> {
    List<RequestOnAct> findRequestOnActsByUserId(Long id);
}
