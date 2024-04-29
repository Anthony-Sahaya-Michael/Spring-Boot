package com.example.busbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.busbooking.configuration.MyClass;

@SpringBootApplication
public class BusbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusbookingApplication.class, args);
		System.out.println("Hello guys");
		// MyClass obj = new MyClass();
		// obj.myMethod();
	}

}
