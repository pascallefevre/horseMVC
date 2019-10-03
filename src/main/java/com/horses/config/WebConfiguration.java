package com.horses.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@Import(JPAConfiguration.class)
@ComponentScan({"com.horses.controller","com.horses.dao","com.horses.controller.api"})
public class WebConfiguration implements WebMvcConfigurer
{
	@Bean
	public UrlBasedViewResolver viewResolver() 
	{
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
		
	/*
	 * public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	 * registry.addResourceHandler("/images/**").addResourceLocations("/images/"); }
	 */
}
