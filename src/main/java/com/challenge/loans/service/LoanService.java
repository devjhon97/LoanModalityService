package com.challenge.loans.service;

import com.challenge.loans.controller.dto.LoanResponse;
import com.challenge.loans.controller.dto.LoanType;
import com.challenge.loans.controller.dto.Loans;
import com.challenge.loans.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public LoanResponse loanAvailability(Customer customer) {
        List<Loans> loans = new ArrayList<>();

        if (customer.isPersonalLoanAvailable("SP", 30, 3000.00, 5000.00)) {
            loans.add(new Loans(LoanType.PERSONAL, 4));
        }

        if (customer.isGuaranteedLoanAvailable("SP", 30, 3000.00, 5000.00)) {
            loans.add(new Loans(LoanType.GUARANTEED, 3));
        }

        if (customer.isConsignmentLoanAvailable(5000.00)) {
            loans.add(new Loans(LoanType.CONSIGNMENT, 2));
        }

        return new LoanResponse(customer.getName(), loans);
    }
}
