package com.vtrbtf.minibank.application.holder;

import com.vtrbtf.minibank.core.domain.holder.Holder;
import lombok.Data;
import lombok.experimental.PackagePrivate;

@Data @PackagePrivate
class GetHolderResponse {
    private String name;
    private String type;
    private String CPF;
    private String CNPJ;

    public GetHolderResponse(Holder holder) {
        name = holder.getName();
        type = holder.getType();
        CPF = holder.getCPF();
        CNPJ = holder.getCNPJ();
    }
}
