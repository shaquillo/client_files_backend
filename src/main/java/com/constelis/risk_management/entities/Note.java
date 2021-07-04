package com.constelis.risk_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Note {

    private String id;

    private String note;

    private Status status;

    private Status document;

    private String document_link;

    private String offer;

    private LocalDate created;

    private LocalDate offer_date;

    public Note(String note, Status status, Status document, String document_link, String offer, LocalDate created, LocalDate offer_date) {
        this.note = note;
        this.status = status;
        this.document = document;
        this.document_link = document_link;
        this.offer = offer;
        this.created = created;
        this.offer_date = offer_date;
    }
}
