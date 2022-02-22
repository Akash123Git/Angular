package com.example.hospitaldb.Repository;

import com.example.hospitaldb.model.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends MongoRepository<Patient,String> {

}
