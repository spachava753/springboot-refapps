package net.thespblog.refapp.basegraphql;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import graphql.kickstart.execution.config.GraphQLServletObjectMapperConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasegraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasegraphqlApplication.class, args);
    }

    @Bean
    public GraphQLServletObjectMapperConfigurer objectMapperConfigurer() {
        return (mapper -> mapper.registerModule(new JavaTimeModule()));
    }
}
