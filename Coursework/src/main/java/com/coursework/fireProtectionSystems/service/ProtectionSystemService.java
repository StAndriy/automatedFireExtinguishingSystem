package com.coursework.fireProtectionSystems.service;

import com.coursework.fireProtectionSystems.exception.ProtectionSystemNotFoundException;
import com.coursework.fireProtectionSystems.model.ProtectionSystem;
import com.coursework.fireProtectionSystems.repository.ProtectionSystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ProtectionSystemService {

    private final ProtectionSystemRepo protectionSystemRepo;

    @Autowired
    public ProtectionSystemService(ProtectionSystemRepo protectionSystemRepo) {
        this.protectionSystemRepo = protectionSystemRepo;
    }


    public ProtectionSystem addSystem(ProtectionSystem system) {
        system.setProtectionSystemCode(UUID.randomUUID().toString());
        return protectionSystemRepo.save(system);
    }

    public List<ProtectionSystem> findAllSystem() {
        return protectionSystemRepo.findAll();
    }

    public ProtectionSystem updateSystem(ProtectionSystem system) {
        return protectionSystemRepo.save(system);
    }

    public ProtectionSystem findSystemById(Long id) {
        return protectionSystemRepo.findProtectionSystemById(id)
                .orElseThrow(() -> new ProtectionSystemNotFoundException("Протипожежної системи за " + id + " не було знайдено"));
    }

    public void deleteSystem(Long id) {
        protectionSystemRepo.deleteById(id);
    }

}
