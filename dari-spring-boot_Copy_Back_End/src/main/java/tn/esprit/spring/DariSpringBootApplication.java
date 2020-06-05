package tn.esprit.spring;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import tn.esprit.spring.controller.FileUploadController;

@SpringBootApplication
@EnableScheduling
public class DariSpringBootApplication {

	public static void main(String[] args)throws Exception  {
		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(DariSpringBootApplication.class, args);
		
		
	}

}
