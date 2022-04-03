import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  // Area de Criação dos Menus Sidebar
   menus: any[] =  [
     {
       "nome": "Dashboard",
       "link": "#",
       "icon": "estate"
     },
     {
      "nome": "Conteudo",
      "link": "#",
      "icon": "files-landscapes"
     },
     {
      "nome": "Estatisticas",
      "link": "#",
      "icon": "chart"
     },
     {
      "nome": "Likes",
      "link": "#",
      "icon": "thumbs-up"
     },
     {
      "nome": "Comentarios",
      "link": "#",
      "icon": "comments"
     },
     {
      "nome": "Compartilhamentos",
      "link": "#",
      "icon": "share"
     }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
