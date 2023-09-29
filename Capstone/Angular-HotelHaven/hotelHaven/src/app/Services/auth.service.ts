import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ISignUpData } from '../Interfaces/isign-up-data';
import { ISignInData } from '../Interfaces/isign-in-data';
import { ILoginResponse } from '../Interfaces/ilogin-response';
import { IRegisterResponse } from '../Interfaces/iregister-response';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  signUp(user: ISignUpData) {
    return this.http.post<IRegisterResponse>('http://localhost:8080/api/auth/register', user);
  }

  signIn(user: ISignInData) {
    return this.http.post<ILoginResponse>('http://localhost:8080/api/auth/login', user);
  }

}
