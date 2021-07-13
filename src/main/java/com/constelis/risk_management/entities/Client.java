package com.constelis.risk_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Client")
public class Client {

    @Id
    private String id;

    private String name;

    private String profession;

    private String category;

    private String tel;

    @Indexed(unique=true)
    private String email;

    private String CP;

    private String address;

    private String town;

    private String linkedIn_link;

    @Field
    private int notation = 1;

    private Account account;

    private List<Note> notes;

    public Client(String name, String profession, String category, String tel, String email, String CP, String address, String town, String linkedIn_link, int notation) {
        this.name = name;
        this.profession = profession;
        this.category = category;
        this.tel = tel;
        this.email = email;
        this.CP = CP;
        this.address = address;
        this.town = town;
        this.linkedIn_link = linkedIn_link;
        this.notation = notation;
    }
}
