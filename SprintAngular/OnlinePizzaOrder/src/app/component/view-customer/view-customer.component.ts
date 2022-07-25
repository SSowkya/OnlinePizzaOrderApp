import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  customer:Customer=new Customer();
  customers:Customer[]=[];
  Issubmitted:boolean;
  private isButtonVisible = true;
  private isShow = false;
  constructor(private customerservice:CustomerService,private router:Router) { }

  ngOnInit() {
   // this.getCouponList();
  }
  public getCustomersList():void{
    this.Issubmitted=true;
    this.isShow=true;
    console.log(this.customer);
    this.customerservice.extractCustomers().subscribe(
      response=>
      {
  this.customers=response;
      }
    )
  }
  public back()
  {
    this.router.navigate(['menu']);

  }
}
