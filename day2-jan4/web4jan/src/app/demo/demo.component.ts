import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {

  Product : any=[];
  pid: number=0;
  constructor() { }

  ngOnInit(): void {
  }

  public process(PName:any,Price:any,Company:any,Image:any)
  {
    
    let pid=++this.pid;
    let pname = PName.value
    let price = Price.value
    let company = Company.value
    let image = Image.value
    this.Product.push({pid,pname,price,company,image});
  }

  public deleteProduct(pid:any){
    this.Product=this.Product.filter((d:any)=>d.pid!=pid)
  }

  public updateImage(p:any,ImageUpdate:any){
    p.image=ImageUpdate.value;
  }
}
