import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../Product';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private response:any;
  constructor(private http:HttpClient) { 
    // this.product=new Product();
  }

  ngOnInit() {
    let obs=this.http.get('http://localhost:8080/UI-Session-11/home');
    obs.subscribe((response)=>this.response=response);
    console.log(this.response);
  //   this.product.product_id=this.response.product_id;
  //   this.product.name=this.response.product_name;
  //   this.product.price=this.response.product_price;
  //   this.product.description=this.response.description;
  //   // const byteString = window.atob(base64);
  // //  const arrayBuffer = new ArrayBuffer(byteString.length);
  // //  const int8Array = new Uint8Array(arrayBuffer);
  // //  for (let i = 0; i < byteString.length; i++) {
  // //    int8Array[i] = byteString.charCodeAt(i);
  // //  }
  //  const blob = new Blob([int8Array], { type: 'image/jpeg' });    `
  //   var blob1 = new Blob([new Uint16Array(this.response[0].image.binaryData)]);  
  //   const imageUrl = URL.createObjectURL(blob1);  
  //   this.product.image=imageUrl;  
  }
}