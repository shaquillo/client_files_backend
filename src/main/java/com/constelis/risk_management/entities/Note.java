package com.constelis.risk_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    private String id;

    private String note;

    private Status status = Status.PENDING;

    private Status document_status = Status.PENDING;

    private String filename;  //filename

    private String offer;

    private String creation_date;

    private String offer_date;

    public Note(String note, Status status, Status document, String filename, String offer, String created, String offer_date) {
        this.note = note;
        this.status = status;
        this.document_status = document;
        this.filename = filename;
        this.offer = offer;
        this.creation_date = created;
        this.offer_date = offer_date;
    }
}
