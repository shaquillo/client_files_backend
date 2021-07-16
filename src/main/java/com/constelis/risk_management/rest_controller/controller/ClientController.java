package com.constelis.risk_management.rest_controller.controller;

import com.constelis.risk_management.entities.Client;
import com.constelis.risk_management.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/client/note/file", method = RequestMethod.POST)
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile file){
        logger.info("uploading file");
        String filename = clientService.uploadFile(file);
        logger.info("name of uploaded file: " + filename);
        HashMap<String, String> respons = new HashMap<String, String>();
        respons.put("filename", filename);
        return respons;
    }

    @RequestMapping(value="/client/note/file/{filename:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getNoteDocument(@PathVariable String filename){
        logger.info("downloading file");
        Resource resource = clientService.loadFile(filename);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_PDF);

        return new ResponseEntity<Resource>(resource, httpHeaders, HttpStatus.OK);
    }

}
