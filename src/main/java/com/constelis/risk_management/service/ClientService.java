package com.constelis.risk_management.service;


import com.constelis.risk_management.entities.Client;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ClientService extends GenericService<Client>{

    public Resource loadFile(String filename);

    public String uploadFile(MultipartFile file);
}
