package edu.hccs.springproject1;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringProject1Application {

	private static void extracted(ConfigurableApplicationContext context) throws IOException {

		StudentController studentController = context.getBean(StudentController.class);
		System.out.println("Students " + studentController.readData());
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringProject1Application.class, args);
	}

}
