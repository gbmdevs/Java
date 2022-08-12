import { Component, OnInit } from '@angular/core';
import {DataSource} from '@angular/cdk/collections';

import {MatTableDataSource} from '@angular/material/table';
export interface PeriodicElement {
   name: string;
   position: number;
   weight: number;
   symbol: string;
 }
 

const ELEMENT_DATA: PeriodicElement[] = [
   {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
   {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
   {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
   {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
   {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'}
 ];

 @Component({
   selector: 'app-dashboard',
   templateUrl: './dashboard.component.html',
   styleUrls: ['./dashboard.component.css']
 })

export class DashboardComponent implements OnInit {

   isPfActive = false;
   isPjActive = false;

   displayedColumns: string[] = ['position','name'];
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
