package com.vtrbtf.minibank.aggregate.client.events;

import com.vtrbtf.minibank.aggregate.client.Company;
import com.vtrbtf.minibank.application.command.model.client.EnrollCompany;

public class CompanyClientEnrolled extends ClientEnrolled<Company> {
    public CompanyClientEnrolled(EnrollCompany command) {
        super(command.getId(), new Company(command));
    }
}
