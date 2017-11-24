package com.aprendendojava.view;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class ViewResolverConfig {
    
  @Bean
  public ViewResolver internalResourceViewResolver(){
    InternalResourceViewResolver viewResolver = 
    		new InternalResourceViewResolver();
        
    return viewResolver;
  }
}
