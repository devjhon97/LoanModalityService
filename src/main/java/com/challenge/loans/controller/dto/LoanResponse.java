package com.challenge.loans.controller.dto;

import java.util.List;

public record LoanResponse(String name,
                           List<Loans> loans) {

    public LoanResponse(String name, List<Loans> loans) {
        this.name = name;
        this.loans = loans;
    }
}
