package com.constelis.risk_management.config;

import com.constelis.risk_management.rest_controller.serviceImpl.ClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Order(1)
public class Startup implements CommandLineRunner {

    @Resource
    ClientServiceImpl clientService;

    Logger logger = LoggerFactory.getLogger(Startup.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("initalising folder for saving files");
        clientService.deleteAll();
        clientService.init();
    }
}
