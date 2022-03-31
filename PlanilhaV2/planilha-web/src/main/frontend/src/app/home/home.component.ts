import { Component, OnInit } from '@angular/core';
import { VERSION } from '@angular/compiler';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
   version= `VErsao do Angular: ${VERSION.full}`;

  constructor() { }

  ngOnInit(): void {
  }

}
