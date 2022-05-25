package com.coursework.fireProtectionSystems.service;

import com.coursework.fireProtectionSystems.model.ProtectionSystem;
import com.coursework.fireProtectionSystems.model.RequestOnAct;
import com.coursework.fireProtectionSystems.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    private final RequestRepo requestRepo;

    public RequestService(RequestRepo requestRepo) {
        this.requestRepo = requestRepo;
    }

    public List<RequestOnAct> findAllRequest() {
        return requestRepo.findAll();
    }

    public void deleteRequest(Long id) {
        requestRepo.deleteById(id);
    }

    public List<RequestOnAct> findById(Long id) {
        return requestRepo.findRequestOnActsByUserId(id);
    }

    public RequestOnAct addRequest(RequestOnAct request) {
        List<RequestOnAct> requestOnActs = requestRepo.findRequestOnActsByUserId(request.getUserId());
        System.out.println(request.getUserId());

        if (requestOnActs != null) {//Забрати це, якщо хочете щоб користувач відправляв безліч запитів
            for (RequestOnAct req : requestOnActs) {
                if (req.getAction() == request.getAction()) {
                    return null;
                }
            }
        }

        return requestRepo.save(request);
    }
}
