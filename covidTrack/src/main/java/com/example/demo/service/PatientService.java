package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Patient;

public interface PatientService {
	
	Patient addPatient(Patient patient);
	Patient fetchPatientById(int id);
	Patient updatePatient(Patient patient);
	String deletePatient(int id);
	List<Patient> fetchAllPatients();

}
