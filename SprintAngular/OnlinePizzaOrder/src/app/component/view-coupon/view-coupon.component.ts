import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Coupon } from 'src/app/model/coupon';
import { CouponService } from 'src/app/service/coupon.service';

@Component({
  selector: 'app-view-coupon',
  templateUrl: './view-coupon.component.html',
  styleUrls: ['./view-coupon.component.css']
})
export class ViewCouponComponent implements OnInit {
  coupon:Coupon=new Coupon();
  coupons:Coupon[]=[];
  Issubmitted:boolean;
  private isButtonVisible = true;
  private isShow = false;
  constructor(private couponservice:CouponService,private router:Router) { }

  ngOnInit() {
   // this.getCouponList();
  }
  public getCouponList():void{
    this.Issubmitted=true;
    this.isShow=true;
    console.log(this.coupon);
    this.couponservice.extractCoupons().subscribe(
      response=>
      {
  this.coupons=response;
      }
    )
  }
  public back()
  {
    this.router.navigate(['menu']);

  }
}
