package net.bifewagyu.gerenciamendodetarefas.apiconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class GerenciamentoConfig {

    @Bean
    public DateTimeFormatter dataformatter() {

        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    }



}
