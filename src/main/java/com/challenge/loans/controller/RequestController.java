package com.challenge.loans.controller;

import com.challenge.loans.controller.dto.LoanRequest;
import com.challenge.loans.controller.dto.LoanResponse;
import com.challenge.loans.domain.Customer;
import com.challenge.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    LoanService loanService;

    @PostMapping("/customer-loans")
    public ResponseEntity<LoanResponse> getLoans(@RequestBody @Valid LoanRequest loanRequest) {
        Customer customer = loanRequest.toCustomer();
        return ResponseEntity.ok(loanService.loanAvailability(customer));
    }
}
