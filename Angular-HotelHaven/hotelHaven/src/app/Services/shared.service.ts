import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  private isDivSelezionato = false;
  private selectedCitySubject = new BehaviorSubject<string>('');
  selectedCity$ = this.selectedCitySubject.asObservable();
  mapCenter: string = '';
  isButtonDisabled1: boolean = true;
  isButtonDisabled2: boolean = true;
  paginaCorrente: number = 1;
  uploadedImageUrls: string[] = [];
  defaultPrice:number = 40;
  customPrice: number | null = null;
  showCustomPrice:boolean = false;
  selectedDiv: number = 0;
  selectedDiv2: number | null = null;
  name: string | null = null;
  isRegisterVisible:boolean = false;
  isLoginVisible: boolean = false;
  isDropdownVisible = false;

  toggleRegister() {
    this.isRegisterVisible = !this.isRegisterVisible;
    this.isDropdownVisible = false;
    console.log(this.isRegisterVisible);
  }

  toggleLogin() {
    this.isLoginVisible = !this.isLoginVisible;
    this.isDropdownVisible = false;
    console.log(this.isLoginVisible);
  }

  setButtonDisabledState1(state: boolean) {
    this.isButtonDisabled1 = state;
  }

  setButtonDisabledState2(state: boolean) {
    this.isButtonDisabled2 = state;
  }

  getButtonDisabledState1() {
    return this.isButtonDisabled1;
  }

  getButtonDisabledState2() {
    return this.isButtonDisabled2;
  }

  setDivSelezionato(): void {
    this.isDivSelezionato = true;
  }

  getDivSelezionato(): boolean {
    return this.isDivSelezionato;
  }

  setSelectedCity(city: string) {
    this.selectedCitySubject.next(city);
  }

  previousComponent() {
    if (this.paginaCorrente > 1) {
      this.paginaCorrente--;
    }
  }

  nextComponent() {
    if (this.paginaCorrente < 13) {
      this.paginaCorrente++;
    }
  }

}
