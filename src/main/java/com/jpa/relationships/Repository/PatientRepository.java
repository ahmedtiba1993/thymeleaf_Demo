package com.jpa.relationships.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.relationships.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	Page<Patient> findByNomContains(String kw,Pageable pageable);
}
