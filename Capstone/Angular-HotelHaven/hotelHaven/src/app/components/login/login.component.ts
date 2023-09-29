import { Component, ElementRef, EventEmitter, Output, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ILoginResponse } from 'src/app/Interfaces/ilogin-response';
import { AuthService } from 'src/app/Services/auth.service';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  @ViewChild('f') form!: NgForm;
  @ViewChild('inputElement') inputElement!: ElementRef;

  constructor(private authService: AuthService) {}

  onSubmit() {
    console.log(this.form.value);
    this.authService.signIn(this.form.value).subscribe(
      (res: ILoginResponse) => {
        console.log(res);
        const token = res.accessToken;
        localStorage.setItem('accessToken', token);
        window.location.reload();
      },
      (err) => {
        console.log(err);
      }
    )
  }

  @Output() closeLogin = new EventEmitter<void>();

  closeComponent() {
    this.closeLogin.emit();
  }

  ngAfterViewInit() {
    this.inputElement.nativeElement.focus();
  }

}
