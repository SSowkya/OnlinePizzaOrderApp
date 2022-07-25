import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pizza } from 'src/app/model/pizza';
import { PizzaService } from 'src/app/service/pizza.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {
  pizza:Pizza=new Pizza();
  pizzas:Pizza[]=[];
  Issubmitted:boolean;
  dtOptions: DataTables.Settings = {};

  constructor(private pizzaservice:PizzaService,private router:Router) { }

  ngOnInit() {
  
   
  }
  public addPizza():void{
    console.log(this.pizza);
    this.pizzaservice.addPizza(this.pizza).subscribe((p)=>
    {
     // this.msg=p['message'];
      //console.log(this.msg);
      swal("Pizza added");
      this.router.navigate(['login']);

    }
  );
  
  }
  public getPizzaList():void{
    this.Issubmitted=true;
    console.log(this.pizza);
    this.pizzaservice.extractPizzas().subscribe(
      response=>
      {
  this.pizzas=response;
      }
    )
  }
  public cancel()
  {
    this.router.navigate(['login']);

  }
}
