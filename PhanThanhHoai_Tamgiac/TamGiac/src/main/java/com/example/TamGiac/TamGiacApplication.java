package com.example.TamGiac;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TamGiacApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext 
			ctx = SpringApplication.run(TamGiacApplication.class, args);
		System.out.println("Hello My First Spring boot application!");
		
		System.out.println("Beans: " + ctx.getBeanDefinitionCount());
		String []beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String s:beanNames)
			System.out.println(s);
	}
}
