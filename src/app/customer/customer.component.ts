import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.scss'
})
export class CustomerComponent {
  

  CustomerArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;
 
  
  first_name : string ="";
  last_name : string ="";
  street : string ="";
  address : string ="";
  city : string ="";
  state : string ="";
  email : string ="";
  phone : Number =0;
 
  currentCustomerID = "";



constructor(private http: HttpClient )
  {
    this.getAllCustomer();
 
  }

  getAllCustomer()
  {
    
    this.http.get("http://localhost:8084/api/v1/customer/getAllCustomer")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.CustomerArray = resultData;
    });
  }
 
  register()
  {
  
    let bodyData = {
      "first_name" : this.first_name,
      "last_name" : this.last_name,
      "street" : this.street,
      "address" : this.address,
      "city" : this.city,
      "state" : this.state,
      "email" : this.email,
      "phone" : this.phone
    };
      
    this.http.post("http://localhost:8084/api/v1/customer/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Employee Registered Successfully");
        this.getAllCustomer();
        this.first_name= '';
        this.last_name= '';
        this.street= '';
        this.address= '';
        this.city= '';
        this.state= '';
        this.email= '';
        this.phone = 0;
    });
  }
  setUpdate(data: any)
  {
        this.first_name= data.first_name;
        this.last_name= data.last_name;
        this.street= data.street;
        this.address= data.address;
        this.city= data.city;
        this.state= data.state;
        this.email= data.email;
        this.phone = data.phone;
        this.currentCustomerID = data.customerid;
  }
 
  UpdateRecords()
  {
    let bodyData = {
      "customerid" : this.currentCustomerID,
      "first_name" : this.first_name,
      "last_name" : this.last_name,
      "street" : this.street,
      "address" : this.address,
      "city" : this.city,
      "state" : this.state,
      "email" : this.email,
      "phone" : this.phone
    };
    
    this.http.put("http://localhost:8084/api/v1/customer/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Employee Registered Updated")
        this.getAllCustomer();
        this.first_name= '';
        this.last_name= '';
        this.street= '';
        this.address= '';
        this.city= '';
        this.state= '';
        this.email= '';
        this.phone = 0;
    });
  }
 
  save()
  {
    if(this.currentCustomerID == '')
    {
        this.register();
    }
      else
      {
       this.UpdateRecords();
      }      
 
  }
 
  setDelete(data: any)
  {
    
    
    this.http.delete("http://localhost:8084/api/v1/customer/deletecustomer"+ "/"+ data.customerid,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Employee Deleted")
        this.getAllCustomer();
        this.first_name= '';
        this.last_name= '';
        this.street= '';
        this.address= '';
        this.city= '';
        this.state= '';
        this.email= '';
        this.phone = 0;
  
    });
 
  }


}
