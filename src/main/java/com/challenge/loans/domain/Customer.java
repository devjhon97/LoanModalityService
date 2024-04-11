package com.challenge.loans.domain;

public class Customer {
    private String name;
    private String CPF;
    private String location;
    private Integer age;

    private Double income;

    public Customer(String name, String CPF, String location, Integer age, Double income) {
        this.name = name;
        this.CPF = CPF;
        this.location = location;
        this.age = age;
        this.income = income;
    }

    private boolean baseLoanAvailability(String location, Integer age, Double minIncome, Double maxIncome) {
        if (this.income <= minIncome) {
            return true;
        }

        return (this.income <= maxIncome) &&
                (this.age < age) &&
                (this.location.equals(location));
    }

    public boolean isPersonalLoanAvailable(String location, Integer age, Double minIncome, Double maxIncome) {
        return baseLoanAvailability(location, age, minIncome, maxIncome);
    }

    public boolean isGuaranteedLoanAvailable(String location, Integer age, Double minIncome, Double maxIncome) {
        return baseLoanAvailability(location, age, minIncome, maxIncome);
    }

    public boolean isConsignmentLoanAvailable(Double income) {
        return this.income >= income;
    }

    public String getName() {
        return this.name;
    }
}
