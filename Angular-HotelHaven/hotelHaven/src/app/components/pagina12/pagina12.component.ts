import { Component } from '@angular/core';

@Component({
  selector: 'app-pagina12',
  templateUrl: './pagina12.component.html',
  styleUrls: ['./pagina12.component.css']
})
export class Pagina12Component {

  buttonClicked1:boolean = false;
  buttonClicked2:boolean = false;
  closeInfo1:boolean = false;
  closeInfo2:boolean = false;

  toggleInfo1() {
    this.buttonClicked1 = !this.buttonClicked1;
  }

  toggleCloseInfo1() {
    this.closeInfo1 = true;
    setTimeout(() => {
      this.buttonClicked1 = false;
      this.closeInfo1 = false;
    }, 500);
  }

  toggleInfo2() {
    this.buttonClicked2 = !this.buttonClicked2;
  }

  toggleCloseInfo2() {
    this.closeInfo2 = true;
    setTimeout(() => {
      this.buttonClicked2 = false;
      this.closeInfo2 = false;
    }, 500);
  }

}
