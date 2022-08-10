import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

   lista = [{
      "name": "Banco Inter",
      "symbol": "attach_money",
      "value": "R$ 3000"
   },{
      "name": "Alelo Refeicão",
      "symbol": "content_copy",
      "value": "R$ 3000"
   },{
    "name": "Iti - Itau",
    "symbol": "content_copy",
    "value": "R$ 3000"
   }];

  constructor() { }

  ngOnInit(): void {
  }

}
