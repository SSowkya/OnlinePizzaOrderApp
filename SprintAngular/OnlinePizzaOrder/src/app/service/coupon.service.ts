import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Coupon } from '../model/coupon';
import { Projecturl } from '../projecturl';

@Injectable({
  providedIn: 'root'
})
export class CouponService {

  url:string=Projecturl.getUrl();
  //put, get, post, delete
    constructor(private http:HttpClient) { }

  
    public addCoupon(coupon:Coupon):Observable<any>
    {
  return this.http.post(this.url+"CreateCoupon", coupon,{responseType:'text'});
    }

    public extractCoupons():Observable<any>
    {
  return this.http.get<any>(this.url+"coupon");
    }
  }