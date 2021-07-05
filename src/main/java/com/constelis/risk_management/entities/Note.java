package com.constelis.risk_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Note {

    private String id;

    private String note;

    private Status status = Status.PENDING;

    private Status document_status = Status.PENDING;

    private String document_link;

    private String offer;

    private LocalDate creation_date = LocalDate.now();

    private LocalDate offer_date;

    public Note(String note, Status status, Status document, String document_link, String offer, LocalDate created, LocalDate offer_date) {
        this.note = note;
        this.status = status;
        this.document_status = document;
        this.document_link = document_link;
        this.offer = offer;
        this.creation_date = created;
        this.offer_date = offer_date;
    }
}
