package com.constelis.risk_management.rest_controller.serviceImpl;

import com.constelis.risk_management.entities.Client;
import com.constelis.risk_management.repository.ClientRepository;
import com.constelis.risk_management.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    protected ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client find(String id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
