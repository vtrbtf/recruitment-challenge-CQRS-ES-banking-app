package com.vtrbtf.minibank.application.query.client.http.payload;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data @EqualsAndHashCode(callSuper = false)
public abstract class GetClient extends ResourceSupport {
}
