import { Component, OnInit } from '@angular/core';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-pagina11',
  templateUrl: './pagina11.component.html',
  styleUrls: ['./pagina11.component.css']
})
export class Pagina11Component implements OnInit {

  priceGuestService:number = 6;
  taxes:number = 4;
  totalPrice:number = 0;
  isEditingPrice:boolean = false;
  isBoxExpanded: boolean = false;
  isBox1Expanded = false;
  isBox2Expanded = false;
  isBox1ContentVisible = false;
  isBox2ContentVisible = false;

  constructor(protected sharedService: SharedService) {}

  ngOnInit():void {
    this.totalPrice = this.sharedService.defaultPrice + this.priceGuestService + this.taxes;
  }

  startEditingPrice(): void {
    if (this.sharedService.defaultPrice !== 40) {
      this.sharedService.customPrice = this.sharedService.defaultPrice;
    }
  }

  onCustomPriceChange(newPrice: number): void {
    this.sharedService.customPrice = newPrice;
    this.sharedService.showCustomPrice = this.sharedService.customPrice !== this.sharedService.defaultPrice;
  }

  toggleBoxVisibility(): void {
    this.isBoxExpanded = !this.isBoxExpanded;
    this.toggleBox2ContentVisibility();
  }

  toggleBox1Visibility(): void {
    this.isBox1Expanded = !this.isBox1Expanded;
    this.isBox2Expanded = !this.isBox2Expanded;
    this.toggleBox1ContentVisibility();
    this.toggleBox2ContentVisibility();
  }

  toggleBox2Visibility(): void {
    this.isBox2Expanded = !this.isBox2Expanded;
    this.isBox1Expanded = !this.isBox1Expanded;
    this.toggleBox2ContentVisibility();
    this.toggleBox1ContentVisibility();
  }

  toggleBox1ContentVisibility(): void {
    this.isBox1ContentVisible = !this.isBox1ContentVisible;
  }

  toggleBox2ContentVisibility(): void {
    this.isBox2ContentVisible = !this.isBox2ContentVisible;
  }

}
