import { Component } from '@angular/core';
import { SharedService } from './Services/shared.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'hotelHaven';
  isAddHomeVisible:boolean = false;

  constructor(protected sharedService: SharedService) {}

  closeRegister() {
    this.sharedService.isRegisterVisible = false;
    console.log(this.sharedService.isRegisterVisible);
  }

  closeLogin() {
    this.sharedService.isLoginVisible = false;
    console.log(this.sharedService.isLoginVisible);
  }

}
