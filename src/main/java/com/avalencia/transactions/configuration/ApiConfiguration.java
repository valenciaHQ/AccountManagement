package com.avalencia.transactions.configuration;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import com.avalencia.transactions.provider.CORSResponseFilter;
import com.avalencia.transactions.provider.NegativeAmountExceptionMapper;
import com.avalencia.transactions.resources.AccountResource;
import io.swagger.jaxrs.config.BeanConfig;

@Configuration
@ApplicationPath("/api")
public class ApiConfiguration extends ResourceConfig {

    @Autowired
    Environment environment;

    /**
     * Each resource or provider must be registered
     */
    public ApiConfiguration() {
        super();
        register(CORSResponseFilter.class);
        register(AccountResource.class);
        register(NegativeAmountExceptionMapper.class);
    }

    /**
     * Build swagger configuration, you can access at http://localhost:8080/api/swagger.json
     * @return a beanConfig with swagger configuration
     */
    @Bean
    public BeanConfig swaggerConfiguration() {
        final BeanConfig beanConfig = new BeanConfig();

        beanConfig.setResourcePackage(environment.getProperty("resource.packages"));

        beanConfig.setTitle(environment.getProperty("application.api.title"));
        beanConfig.setVersion(environment.getProperty("application.api.version"));
        beanConfig.setBasePath(environment.getProperty("application.basepath"));
        beanConfig.setHost(environment.getProperty("application.host"));
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);

        return beanConfig;
    }
}
