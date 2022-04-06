import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
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

}
