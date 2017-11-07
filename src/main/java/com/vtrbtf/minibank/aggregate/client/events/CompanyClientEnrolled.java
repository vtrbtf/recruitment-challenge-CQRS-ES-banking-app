package com.vtrbtf.minibank.aggregate.client.events;

import com.vtrbtf.minibank.aggregate.client.Company;
import com.vtrbtf.minibank.application.command.client.EnrollCompanyClient;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CompanyClientEnrolled extends ClientEnrolled<Company> {
    public CompanyClientEnrolled(EnrollCompanyClient command) {
        super(command.getClientId(), new Company(command));
    }
}
