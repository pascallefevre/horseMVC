package com.horses.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@Import(JPAConfiguration.class)
@ComponentScan("com.horses.dao")
public class ContextConfiguration {

}
