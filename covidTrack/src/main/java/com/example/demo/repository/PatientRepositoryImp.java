package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Patient;
@Repository
@Transactional//must for entitymanager
public class PatientRepositoryImp  implements PatientRepository{

	@Autowired
	private GenericRepository genericRepo;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Patient createPatient(Patient patient) {
		
		return genericRepo.specialSave(patient);
	}

	@Override
	public int updatePatient(Patient patient) {
		
		int pId=patient.getPatientId();
		String fName=patient.getFullName();
		String phNo=patient.getPhoneNumber();
		String bGroup=patient.getBloodGroup();
		
		return entityManager
				.createQuery("update Patient p set p.fullName=:fName, p.phoneNumber=:phNo, p.bloodGroup=:bGroup where p.patientId=:pId")
				.setParameter("fName", fName)
				.setParameter("phNo", phNo)
				.setParameter("bGroup", bGroup)
				.setParameter("pId", pId)
				.executeUpdate();
	}

	@Override
	public int deletePatientById(int id) {
	
		return entityManager.createQuery("delete p from Patient p where p.patientId =: id" )
				.setParameter("id", id)
				.executeUpdate();
	}

	@Override
	public Patient viewPatientById(int id) {
		
		return genericRepo.specialFetchById(Patient.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> viewAllPatients() {
		
		return entityManager.createQuery("select p from Patient p")
				.getResultList();
	}

	@Override
	public boolean checkPatientPresentOrNotByID(int id) {
		
		return (Long) entityManager.createQuery("select count(p.patientId) from Patient p where p.patientId=:id")
				.setParameter("id", id)
				.getSingleResult() == 1 ? true : false;
	}

}
