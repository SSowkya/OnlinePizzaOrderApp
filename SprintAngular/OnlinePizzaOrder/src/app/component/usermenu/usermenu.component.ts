import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { Pizza } from 'src/app/model/pizza';
import { User } from 'src/app/model/user';
import { CustomerService } from 'src/app/service/customer.service';
import { PizzaService } from 'src/app/service/pizza.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-usermenu',
  templateUrl: './usermenu.component.html',
  styleUrls: ['./usermenu.component.css']
})
export class UsermenuComponent implements OnInit {
  pizza:Pizza=new Pizza();
  pizzas:Pizza[]=[];
  
  Issubmitted:boolean;
  showDialog4: boolean;
  user:User=new User();
  users:User[]=[];
newPassword:string;
userId:number;
  UserOldPassword: string;
  Uname: string;
  isOpen: boolean;

  constructor(private pizzaservice:PizzaService,private router:Router,private route:ActivatedRoute,private customerService:CustomerService) { }

  ngOnInit() {
    this.Uname=this.route.snapshot.params['name']

    this.customerService.extractUserById(this.userId).subscribe(response=>{
      this.user=response;
      this.UserOldPassword=this.user.userPassword;
      console.log(this.UserOldPassword);
      
    })
    }
  

}
