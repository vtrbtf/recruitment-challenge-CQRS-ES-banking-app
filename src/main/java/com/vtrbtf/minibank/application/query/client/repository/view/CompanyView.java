package com.vtrbtf.minibank.application.query.client.repository.view;

import com.mongodb.gridfs.CLI;
import com.vtrbtf.minibank.aggregate.client.events.CompanyClientEnrolled;
import com.vtrbtf.minibank.application.query.client.http.payload.GetClient;
import com.vtrbtf.minibank.application.query.client.http.payload.GetCompanyClient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import java.util.ArrayList;


@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@BsonDiscriminator
public class CompanyView implements HolderView {
    String CNPJ;

    public CompanyView(CompanyClientEnrolled company) {
        CNPJ = company.getHolder().getCNPJ();
    }

    @Override
    public GetClient toPayload(ClientView view) {
        return new GetCompanyClient(view, this);
    }
}
