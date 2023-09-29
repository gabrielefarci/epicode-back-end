import { Component, ElementRef, EventEmitter, Output, ViewChild } from '@angular/core';
import { GeocodingService } from 'src/app/Services/geocoding.service';
import { SharedService } from 'src/app/Services/shared.service';
import { FooterBtnComponent } from '../footer-btn/footer-btn.component';

@Component({
  selector: 'app-address-autocomplete',
  templateUrl: './address-autocomplete.component.html',
  styleUrls: ['./address-autocomplete.component.css'],
  template: `
    <ul *ngIf="suggestions.length > 0" id="address-list">
      <li *ngFor="let suggestion of suggestions">
        <a (click)="selectSuggestion(suggestion)">{{ suggestion.formatted_address }}</a>
      </li>
    </ul>
  `,
})
export class AddressAutocompleteComponent {

  @ViewChild('addressInput') addressInput!: ElementRef;
  @ViewChild('cityInput') cityInput!: ElementRef;
  @Output() onCitySelect: EventEmitter<string> = new EventEmitter<string>();

  googleMapsApiKey = 'AIzaSyDtEAPXpQJ6RwvKEatZSAvnrOXliE8XzN4';

  address: string = '';
  suggestions: any[] = [];
  isDivOpen: boolean = false;
  divHeight: string = 'auto';
  selectedCity: string = '';
  addressMap: string = 'CastellodiAcera';
  mapCenter: string = 'CastellodiAcera';

  constructor(private geocodingService: GeocodingService, protected sharedService: SharedService) {}

  searchAddress(query: string): void {
    this.geocodingService.getAddressSuggestions(query).subscribe((data: any) => {
      this.suggestions = data.results;
      this.divHeight = this.suggestions.length > 0 ? 'auto' : '0';
      console.log(this.suggestions)
    });
  }

  toggleDiv() {
    this.isDivOpen = !this.isDivOpen;
  }

  selectSuggestion(suggestion: any) {
    this.address = suggestion.formatted_address;
    this.isDivOpen = false;
    this.sharedService.nextComponent();
    this.sharedService.setSelectedCity(suggestion.address_components[0].short_name);
    this.onCitySelect.emit(suggestion.formatted_address);
  }

  goNextPage() {
    return this.sharedService.nextComponent();
  }

}
