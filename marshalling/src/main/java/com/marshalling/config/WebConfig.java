package com.marshalling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

@Configuration
public class WebConfig {
	
	@Bean
    public Jaxb2RootElementHttpMessageConverter xmlHttpMessageConverter() {
        return new Jaxb2RootElementHttpMessageConverter();
    }

}
