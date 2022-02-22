package com.example.hospitaldb.controller;

import java.util.List;

import com.example.hospitaldb.Service.PatientService;
import com.example.hospitaldb.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/getpatientdata")
    public ResponseEntity getPatientDetails(){
        List<Patient> patDetails = patientService.getPatientDetails();
        if(patDetails==null){
            return ResponseEntity.ok("Empty Database");
        }
        return ResponseEntity.ok(patDetails);
    }

    @PostMapping("/addPatient")
    public ResponseEntity doAddPatient(@RequestBody Patient pat){
        Patient p = patientService.doAddPatient(pat);
        if(p==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/deletePatientById/{id}")
    public ResponseEntity doPatientDeleteById(@PathVariable String id){
        String S=patientService.deleteById(id);
        return ResponseEntity.ok(S);
    }  

    @PutMapping("/updatePatientRecord")
    public ResponseEntity doUpdateRecord(@RequestBody Patient pat){
        if(pat.getId()==null){
            return ResponseEntity.ok("bad request");
        }
        Patient p=patientService.doUpdateRecord(pat);
        if(p==null){
            return ResponseEntity.ok("bad gateway");
        }
        return ResponseEntity.ok(p);
    }
    
}
