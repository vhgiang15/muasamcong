package com.ungdungso;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MuasamcongApplication {
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();	
	}	

	public static void main(String[] args) {
		SpringApplication.run(MuasamcongApplication.class, args);		
		//String certificatesTrustStorePath = "C:/Program Files/Java/jdk-17/lib/security/cacerts"; // up lên tomcat thì chuyển sang ghi chú
		//System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);  // up lên tomcat thì chuyển sang ghi chú
	}

}
