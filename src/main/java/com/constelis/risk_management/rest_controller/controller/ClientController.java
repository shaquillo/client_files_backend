package com.constelis.risk_management.rest_controller.controller;

import com.constelis.risk_management.entities.Client;
import com.constelis.risk_management.rest_controller.serviceImpl.ClientServiceImpl;
import com.constelis.risk_management.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class ClientController {

    @Autowired
    protected ClientService clientService;

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public Client save(@RequestBody Client client){
        return clientService.create(client);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public Client find(@PathVariable String id){
        return clientService.find(id);
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public List<Client> findAll(){
        return clientService.findAll();
    }

}
