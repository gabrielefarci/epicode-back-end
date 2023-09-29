import { Component } from '@angular/core';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-footer-btn',
  templateUrl: './footer-btn.component.html',
  styleUrls: ['./footer-btn.component.css']
})
export class FooterBtnComponent {

  isCitySelected: boolean = false;
  disabilitaPulsanteAvanti = true;

  constructor(protected sharedService: SharedService) {}

  isDivSelezionato(): boolean {
    return this.sharedService.getDivSelezionato();
  }

  isButtonDisabled1(): boolean {
    return this.sharedService.getButtonDisabledState1();
  }

  isButtonDisabled2(): boolean {
    return this.sharedService.getButtonDisabledState2();
  }

}
