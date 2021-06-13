package com.example.projecta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.example.projecta.config.DatabaseConfiguration;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
//@Import({DatabaseConfiguration.class })
public class ProjectaApplication {

	public static void main(String[] args) {
	
		//  System.setProperty("server.servlet.context-path", "/myapp");
		SpringApplication.run(ProjectaApplication.class, args);
	}
	
    @Bean
    public WebMvcConfigurer configurer () {
        return new WebMvcConfigurerAdapter() {
          
        };
    }

}
