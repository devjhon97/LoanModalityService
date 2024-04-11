package com.challenge.loans.controller.dto;

import com.challenge.loans.domain.Customer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record LoanRequest(@NotNull @Min(18) Integer age,
                          @CPF String cpf,
                          @NotNull @NotBlank String name,
                          @NotNull @Min(1300) Double income,
                          @NotNull @NotBlank String location) {

    public Customer toCustomer() {
        return new Customer(
                this.name,
                this.cpf,
                this.location,
                this.age,
                this.income);
    }
}
