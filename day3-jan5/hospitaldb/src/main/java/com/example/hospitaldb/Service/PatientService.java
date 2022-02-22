package com.example.hospitaldb.Service;

import java.util.List;
import java.util.UUID;

import com.example.hospitaldb.Repository.PatientRepo;
import com.example.hospitaldb.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public List<Patient> getPatientDetails() {
        List<Patient> patDetails = patientRepo.findAll();
        if(patDetails.size()>0){
            
            return patDetails;
        }
        return null;
        
    }

    public Patient doAddPatient(Patient pat) {
        pat.setId(UUID.randomUUID().toString());
        try{
            Patient p = patientRepo.insert(pat);
            return p;
        }
        catch(Exception e){
            return null;
        }
    }

    public String deleteById(String id) {
        try {
            patientRepo.deleteById(id);
            return "record is deleted";
        } catch (Exception e) {
            return "could not delete record";
        } 
    }

    public Patient doUpdateRecord(Patient pat) {
        try{
            Patient p = patientRepo.save(pat);
            return p;
        }catch(Exception e){
            return null;
        }
    }

}
