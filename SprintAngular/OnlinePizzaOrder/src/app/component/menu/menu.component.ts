import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  name:string="";
  msg:string=""
  adminFlag:boolean;
  customerFlag: boolean;
constructor(private route:ActivatedRoute,private loginService:LoginService) { }

ngOnInit() {
  this.name=this.route.snapshot.params['name']
  this.adminFlag=this.loginService.isAdmin();
  this.customerFlag=this.loginService.isCustomer();

}
handleLogout():void
  {
    this.loginService.invokeLogout();
    swal("Logged Out Succesfully")

  }
}