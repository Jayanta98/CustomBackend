package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientException;

import com.example.demo.repository.PatientRepository;

@Service
public class PatientServiceImp implements PatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Override
	public Patient addPatient(Patient patient) {

		try {
			return patientRepo.createPatient(patient);
			
		} catch (Exception e) {
			throw new PatientException("Error during create the Patient-->"+e);
		}
		
	}

	@Override
	public Patient fetchPatientById(int id) {
		try {
			if(patientRepo.checkPatientPresentOrNotByID(id)) {
				return patientRepo.viewPatientById(id);
			}else {
				throw new PatientException("Patient Not Exist with that Id");
			}
		} catch (Exception e) {
			
		throw new PatientException("Error --Patient Not Exist with that Id"+e);
		}
		
	}

	@Override
	public Patient updatePatient(Patient patient) {
	
		try {
			if(patientRepo.checkPatientPresentOrNotByID(patient.getPatientId())) {
				patientRepo.updatePatient(patient);
				return patientRepo.viewPatientById(patient.getPatientId());
			}else {
				throw new PatientException("Update Not Occoured");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new PatientException("Update Not Occoured"+e);
		}
	}

	@Override
	public String deletePatient(int id) {
		
		try {
			patientRepo.deletePatientById(id);
			return "Delete Done";
			
		} catch (Exception e) {
			throw new PatientException("Delete Not Occoured"+e);
		}
	}

	@Override
	public List<Patient> fetchAllPatients() {
	
	try {
	 return	patientRepo.viewAllPatients();
		
	} catch (Exception e) {
		throw new PatientException("All Patient Not fetched");
	}
	}

}
