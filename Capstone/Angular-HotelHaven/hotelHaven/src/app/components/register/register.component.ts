import { AuthService } from './../../Services/auth.service';
import { Component, ElementRef, EventEmitter, Output, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { IRegisterResponse } from 'src/app/Interfaces/iregister-response';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  @ViewChild('f') form!: NgForm;
  @ViewChild('inputElement') inputElement!: ElementRef;

  constructor(private authService: AuthService) {}

  onSubmit() {
    console.log(this.form.value);
    this.authService.signUp(this.form.value).subscribe(
      (res: IRegisterResponse) => {
        console.log(res);
        if (res.name) {
          const name = res.name;
          localStorage.setItem('name', name);
          console.log("Il nome " + name + " è stato salvato nel local storage");
        }
      },
      (err) => {
        console.log(err);
      }
    )
  }

  @Output() closeRegistration = new EventEmitter<void>();

  closeComponent() {
    this.closeRegistration.emit();
  }

  ngAfterViewInit() {
    this.inputElement.nativeElement.focus();
  }

}
