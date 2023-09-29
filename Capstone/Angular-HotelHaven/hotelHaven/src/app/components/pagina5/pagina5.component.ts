import { Component, OnInit } from '@angular/core';
import { CountryService } from 'src/app/Services/country.service';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-pagina5',
  templateUrl: './pagina5.component.html',
  styleUrls: ['./pagina5.component.css']
})
export class Pagina5Component implements OnInit {

  selectedCity: string = '';
  selectedAddress: string = '';
  indirizzo1: string = '';
  isIndirizzoInserito: boolean = false;
  selectedCountry: string = '';
  countries: any[] = [];

  googleMapsApiKey = 'AIzaSyDtEAPXpQJ6RwvKEatZSAvnrOXliE8XzN4';

  initialLatitude = 40.7128;
  initialLongitude = -74.0060;

  public lat: number = this.initialLatitude;
  public lng: number = this.initialLongitude;

  constructor(private sharedService: SharedService,private countryService: CountryService) {
    this.sharedService.selectedCity$.subscribe((city) => {
      this.selectedCity = city;
      console.log(this.selectedCity)
    });
  }

  ngOnInit(): void {
    this.countryService.getAllCountries().subscribe((data: any) => {
      this.countries = data;
    });
  }

  onIndirizzo1InputChange() {
    this.updateButtonState();
    this.selectedAddress = this.indirizzo1;
    this.isIndirizzoInserito = this.indirizzo1.trim() !== '';
  }

  updateButtonState() {
    const isIndirizzo1Valid = this.indirizzo1.length > 0;
    this.sharedService.setButtonDisabledState1(!isIndirizzo1Valid);
  }

  updateMapImage() {
    // Costruisci l'URL dell'immagine della mappa utilizzando selectedCity come centro
    const mapImageUrl = `https://maps.googleapis.com/maps/api/staticmap?center=${this.selectedCity}&zoom=12&size=600x250&key=${this.googleMapsApiKey}`;

    // Aggiorna l'URL nell'immagine della mappa
    const mapImage = document.getElementById('map-image') as HTMLImageElement;
    mapImage.src = mapImageUrl;
  }

}
