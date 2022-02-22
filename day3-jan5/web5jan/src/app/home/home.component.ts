import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit 
{
  public patients:any = [];
  public editStatus:any = false;
  public tempdata:any=undefined;
  constructor(private http:HttpClient) { 

  }

  save(frm:NgForm){
    console.log(frm.value)
    this.http.post("http://localhost:9898/patient/addPatient",frm.value).subscribe(data=>{
        this.patients.push(data)
    })
  }

  delPatient(id:String){
    console.log(id)
    this.http.delete(`http://localhost:9898/patient/deletePatientById/${id}`).subscribe(data=>{
      console.log(data)
      
    })
  }


edit(pat:any){
  this.tempdata=pat;
  this.editStatus=true;
  console.log(this.tempdata.id);
}

update(frm:NgForm){
 
  let id=this.tempdata.id;
  console.log(id)
  console.log(frm.value)
  this.http.put(`"http://localhost:9898/patient/updatePatientRecord`,frm.value).subscribe(data=>{
    if(data=="bad request" || data=="bad gate"){
      
    }else{
      this.patients=this.patients.map((ob:any)=>ob.id==id?data:ob)
    }
  })
  this.tempdata=undefined;
  this.editStatus=false;
}

  ngOnInit(): void 
  {
    this.http.get("http://localhost:9898/patient/getpatientdata").subscribe(data=>{
      if(data!="Empty Database"){
        this.patients = data
      }
    });
  }





}