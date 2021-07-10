package com.constelis.risk_management.rest_controller.controller;

import com.constelis.risk_management.entities.Client;
import com.constelis.risk_management.rest_controller.serviceImpl.ClientServiceImpl;
import com.constelis.risk_management.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClientController {

    Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    protected ClientService clientService;

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public Client save(@RequestBody Client client){
        logger.info("Restcontroller - saving client: " + client);
        return clientService.create(client);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public Client find(@PathVariable String id){
        logger.info("Restcontroller - looking client with id: " + id);
        Client client = clientService.find(id);
        logger.info("RestController - Returning client: " + client);
        return client;
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public List<Client> findAll(){
        logger.info("Restcontroller - looking for all clients");
        List<Client> clients = clientService.findAll();
        logger.info("Restcontroller - returning all clients: " + clients);
        return clients;
    }

}
