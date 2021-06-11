package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Patient;



public interface PatientRepository {
	
	Patient createPatient(Patient patient);
	int updatePatient(Patient patient);
	int deletePatientById(int id);
	Patient viewPatientById(int id);
	List<Patient> viewAllPatients();
	
	boolean checkPatientPresentOrNotByID(int id);

}
