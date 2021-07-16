package com.constelis.risk_management.rest_controller.serviceImpl;

import com.constelis.risk_management.entities.Client;
import com.constelis.risk_management.entities.Note;
import com.constelis.risk_management.repository.ClientRepository;
import com.constelis.risk_management.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    private final Path rootLocation = Paths.get("upload-dir");

    @Autowired
    protected ClientRepository clientRepository;

    @Override
    public Client create(Client client) {

        logger.info("Creating client: " + client);

//        MultipartFile file;
//        for(int i=0; i<client.getNotes().size(); i++){
//            file = client.getNotes().get(i).getFile();
//            client.getNotes().get(i).setFilename(file.getOriginalFilename());
//            try {
//                logger.info("copying file ----- ");
//                Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
//            } catch (IOException e) {
//                logger.info("File uplaod failed during client creation");
//                e.printStackTrace();
//            }
//        }
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

    public void init() {
        logger.info("ClientServiceImpl - Creating file storage directory");
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }

    public void deleteAll() {
        logger.info("ClientServiceImpl - deleting file storage directory");
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public Resource loadFile(String filename) {
        logger.info("Downloading file with filename: "+ filename);
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            logger.info("file path: " +  file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                logger.info("File with name does not exists " + filename);
                throw new RuntimeException("FAIL! file does not exist");
            }
        } catch (MalformedURLException e) {
            logger.info("Error during file download");
            throw new RuntimeException("FAIL! Error");
        }
    }

    @Override
    public String uploadFile(MultipartFile file) {

        String filename = file.getOriginalFilename();

        try {
            try {
                Files.copy(file.getInputStream(), this.rootLocation.resolve(filename));
            } catch (FileAlreadyExistsException e) {
                filename = StringUtils.cleanPath(file.getOriginalFilename());
                Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            } catch(Exception e){
                e.printStackTrace();
            }

            return filename;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
