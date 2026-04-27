package com.jadeilton.bff.agendador_tarefas.infrastructure.client.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeingConfig {




    @Bean
    public FeignError feingError(){
        return new FeignError();
    }
}
