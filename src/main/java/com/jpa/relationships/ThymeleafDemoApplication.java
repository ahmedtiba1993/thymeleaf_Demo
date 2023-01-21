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
	
	//@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
		return args ->{
			patientRepository.save(new Patient(null,"ahmed",new Date(),false,102));
			patientRepository.save(new Patient(null,"test1",new Date(),true,130));
			patientRepository.save(new Patient(null,"test2",new Date(),true,130));
			patientRepository.save(new Patient(null,"test3",new Date(),true,130));
			patientRepository.save(new Patient(null,"test4",new Date(),true,130));
			patientRepository.save(new Patient(null,"test5",new Date(),true,130));
			patientRepository.save(new Patient(null,"test6",new Date(),true,130));
			patientRepository.save(new Patient(null,"test7",new Date(),true,130));
			patientRepository.save(new Patient(null,"test8",new Date(),true,130));
			patientRepository.save(new Patient(null,"test9",new Date(),true,130));
			patientRepository.save(new Patient(null,"test10",new Date(),true,130));
			patientRepository.save(new Patient(null,"test11",new Date(),true,130));


			patientRepository.findAll().forEach(p->{
				System.out.print(p);
			});
		};
	}

}
