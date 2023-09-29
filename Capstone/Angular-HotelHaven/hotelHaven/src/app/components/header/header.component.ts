import { Component, ElementRef, EventEmitter, HostListener, Output } from '@angular/core';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  @Output() registerClicked = new EventEmitter<void>();
  @Output() loginClicked = new EventEmitter<void>();

  showComponent = false;

  accessToken = localStorage.getItem('accessToken');

  constructor(private el: ElementRef, protected sharedService: SharedService) {}

  toggleDropdown() {
    this.sharedService.isDropdownVisible = !this.sharedService.isDropdownVisible;
  }

  @HostListener('document:click', ['$event'])
  onClick(event: Event): void {
    const isClickInside = this.el.nativeElement.contains(event.target);
    if (!isClickInside) {
      this.sharedService.isDropdownVisible = false;
    }
  }

  toggleComponent() {
    this.showComponent = !this.showComponent;
  }

  // onRegisterClick() {
  //   this.registerClicked.emit();
  //   this.isDropdownVisible = false;
  // }

  // onLoginClick() {
  //   this.loginClicked.emit();
  //   this.isDropdownVisible = false;
  //   console.log("Accesso...")
  // }

  logout() {
    localStorage.removeItem('accessToken');
    window.location.reload();
  }

}
