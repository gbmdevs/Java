import { Component, OnInit } from '@angular/core';
import {DataSource} from '@angular/cdk/collections';

import {MatTableDataSource} from '@angular/material/table';
export interface PeriodicElement {
   name: string;
   dataVencimento: string,
   valor: number,
   situacao: string
 }
 

const ELEMENT_DATA: PeriodicElement[] = [
   {name: 'Cartão de Crédito', dataVencimento: "22/10/2022", valor: 3000, situacao: 'S'},
   {name: 'INSS - Pró labore', dataVencimento: "22/10/2022", valor: 3000, situacao: 'N'},
   {name: 'INSS - Pró labore', dataVencimento: "22/10/2022", valor: 3000, situacao: 'N'},
   {name: 'INSS - Pró labore', dataVencimento: "22/10/2022", valor: 3000, situacao: 'S'}
 ];

 @Component({
   selector: 'app-dashboard',
   templateUrl: './dashboard.component.html',
   styleUrls: ['./dashboard.component.css']
 })

export class DashboardComponent implements OnInit {

   isPfActive = false;
   isPjActive = false;

   displayedColumns: string[] = ['name','dataVencimento','valor','situacao'];
   dataSource = ELEMENT_DATA;

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
   },
   {"name": "Iti - Itau",
    "symbol": "content_copy",
    "value": "R$ 3000"
   }];

  constructor() { }

  ngOnInit(): void {
  }

  selecaoPj(): void{
       if(!this.isPjActive) {
         this.isPjActive = true;
       }
  }

}
