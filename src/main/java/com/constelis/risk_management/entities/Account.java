package com.constelis.risk_management.entities;

import lombok.Data;

@Data
public class Account {

    private int score;

    private int ratio;

    private int risk;

    private Status status;

    private int investment_plan;
}
