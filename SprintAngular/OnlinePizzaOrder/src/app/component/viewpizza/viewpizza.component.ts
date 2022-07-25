import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pizza } from 'src/app/model/pizza';
import { PizzaService } from 'src/app/service/pizza.service';
import swal from 'sweetalert';
@Component({
  selector: 'app-viewpizza',
  templateUrl: './viewpizza.component.html',
  styleUrls: ['./viewpizza.component.css']
})
export class ViewpizzaComponent implements OnInit {
  pizza:Pizza=new Pizza();
  pizzas:Pizza[]=[];
  Issubmitted:boolean;
  private isButtonVisible = true;
  private isShow = false;

  

  constructor(private pizzaservice:PizzaService,private router:Router) { }


  ngOnInit() {
  }
  public getPizzaList():void{
    this.Issubmitted=true;
    this.isShow=true;
    console.log(this.pizza);
    this.pizzaservice.extractPizzas().subscribe(
      response=>
      {
  this.pizzas=response;
      }
    )
  }
  public back()
  {
    this.router.navigate(['menu']);

  }
}
