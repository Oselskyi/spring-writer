package com.learning.csv.writer.configuration;

import com.learning.csv.writer.service.CSVWriter;
import com.learning.csv.writer.service.WriterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Configuration
public class Config {

//    @Bean
//    @Scope(scopeName = SCOPE_PROTOTYPE)
//    public CSVWriter csvWriter(){
//        return new CSVWriter();
//    }

    @Bean
    WriterFactory writerFactory(){
        return new WriterFactory();
    }
}
