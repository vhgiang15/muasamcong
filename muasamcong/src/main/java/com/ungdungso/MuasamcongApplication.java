package com.ungdungso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MuasamcongApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuasamcongApplication.class, args);
		
		String certificatesTrustStorePath = "C:/Program Files/Java/jdk-17/lib/security/cacerts";
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
	}

}
