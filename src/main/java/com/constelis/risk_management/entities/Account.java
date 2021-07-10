package com.constelis.risk_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private int score;

    private int ratio;

    private int risk;

    private Status status = Status.PENDING;

    private String investment_plan;
}
