package com.example.hospitaldb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Data
@Document(collection = "Patient")
public class Patient {
    
   private String id;
   private String name;
   private int age;
   private String gender;

}
