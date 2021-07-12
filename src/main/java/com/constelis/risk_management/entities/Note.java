package com.constelis.risk_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    private String id;

    private String note;

    private Status status = Status.PENDING;

    private Status document_status = Status.PENDING;

    private MultipartFile file;

    private String filename;  //filename

    private String offer;

    private LocalDate creation_date;

    private LocalDate offer_date;

    public Note(String note, Status status, Status document, MultipartFile file, String filename, String offer, LocalDate created, LocalDate offer_date) {
        this.note = note;
        this.status = status;
        this.document_status = document;
        this.file = file;
        this.filename = filename;
        if(this.file){
            this.filename = this.file.getOriginalFilename();
        }
        this.offer = offer;
        this.creation_date = created;
        this.offer_date = offer_date;
    }
}
