package com.avalencia.transactions.configuration;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import com.avalencia.transactions.provider.CORSResponseFilter;
import com.avalencia.transactions.provider.NegativeAmountExceptionMapper;
import com.avalencia.transactions.resources.AccountResource;

@Configuration
@ApplicationPath("/api")
public class ApiConfiguration extends ResourceConfig {

    /**
     * Each resource or provider must be registered
     */
    public ApiConfiguration() {
        super();
        register(CORSResponseFilter.class);
        register(AccountResource.class);
        register(NegativeAmountExceptionMapper.class);
    }
}
