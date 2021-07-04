package com.constelis.risk_management;

import com.constelis.risk_management.entities.Client;
import com.constelis.risk_management.entities.Status;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RiskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskManagementApplication.class, args);

		System.out.println("Creating new client");

//		notes = ArrayList<>
//
//		Client client = new Client("Shaquille", "Student", "Computer engineer", "671090017", "chimishaquille@gmail.com", "8309", "Melen", "Yaounde", "linked.com/shaquille", 3);
//		client.setAccount(new com.constelis.risk_management.entities.Account(2, 2, 2, Status.TREATED, 2));
//		client.setNotes();
	}

}
