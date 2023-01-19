package com.jpa.relationships;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.relationships.Repository.PatientRepository;
import com.jpa.relationships.models.Patient;

@SpringBootApplication
public class ThymeleafDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafDemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
		return args ->{
			patientRepository.save(new Patient(null,"ahmed",new Date(),false,12));
			patientRepository.save(new Patient(null,"test",new Date(),true,13));
			patientRepository.save(new Patient(null,"ahmed 2",new Date(),true,14));
			patientRepository.save(new Patient(null,"test 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"ahmed 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"test 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"test 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"test 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"ahmed 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"test 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"test 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"ahmed 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"test 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"ahmed 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"test 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"ahmed 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"ahmed 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"ahmed 3",new Date(),false,17));
			patientRepository.save(new Patient(null,"ahmed 3",new Date(),false,17));

			patientRepository.findAll().forEach(p->{
				System.out.print(p);
			});
		};
	}

}
