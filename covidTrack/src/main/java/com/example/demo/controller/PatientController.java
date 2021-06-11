package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@GetMapping("/patientById")
	public Patient getPatientById(@RequestParam("pId")int id) {
		return patientService.fetchPatientById(id);
	}
	
	@PostMapping("/patient")
	public Patient postPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
}
