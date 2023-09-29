import { AddressAutocompleteComponent } from './../address-autocomplete/address-autocomplete.component';
import { Component } from '@angular/core';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-mappa',
  templateUrl: './mappa.component.html',
  styleUrls: ['./mappa.component.css']
})
export class MappaComponent {

  private cities: string[] = [];
  filteredCities: string[] = [];
  searchText = '';

  mappaURL = 'https://maps.googleapis.com/maps/api/staticmap?center=CastellodiAcera&zoom=12&size=600x600&key=AIzaSyDtEAPXpQJ6RwvKEatZSAvnrOXliE8XzN4';

  googleMapsApiKey = 'AIzaSyDtEAPXpQJ6RwvKEatZSAvnrOXliE8XzN4';

  initialLatitude = 40.7128;
  initialLongitude = -74.0060;

  public lat: number = this.initialLatitude;
  public lng: number = this.initialLongitude;

  constructor(protected sharedService: SharedService, protected addressAutoComplete: AddressAutocompleteComponent) {}

  onInputChange(): void {
    this.filteredCities = this.cities.filter(city =>
      city.toLowerCase().includes(this.searchText.toLowerCase())
    );
  }

}
