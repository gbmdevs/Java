import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, retry } from 'rxjs';

import { Estudantes} from './model/estudantes';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  
  servidorJavaUrl:string = "http://localhost:3200/api";
   
  constructor(private httpClient: HttpClient) {}

  // Lista de Todos os Paths para o servidor
  get_estudantes(){
     return this.httpClient
            .get<Estudantes>(this.servidorJavaUrl + '/estudantes')
            .pipe(retry(1), catchError(this.errorHandl));
  }


  // Error Handling
  errorHandl(error: any){
    console.log("Entrou no handle");
    let errorMessage = '';
    if (error.error instanceof ErrorEvent){
      errorMessage = error.error.message;
    }

    return errorMessage;

  }
}
