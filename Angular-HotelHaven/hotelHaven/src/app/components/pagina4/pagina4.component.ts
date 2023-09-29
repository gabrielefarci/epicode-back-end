import { Component } from '@angular/core';
import { map } from 'rxjs';

@Component({
  selector: 'app-pagina4',
  templateUrl: './pagina4.component.html',
  styleUrls: ['./pagina4.component.css']
})
export class Pagina4Component {

  public selectedLocation!: string;

  public mapOptions: any = {
    center: { lat: 0, lng: 0 },
    zoom: 8,
  };
  http: any;

  public updateMap() {
    this.geocodeLocation(this.selectedLocation)
      .then((coordinates: { lat: number, lng: number }) => {
        this.mapOptions.center = coordinates;
      })
      .catch((error: any) => {
        console.error('Errore durante la geocodifica della località:', error);
      });
  }

  private geocodeLocation(location: string) {
    const apiKey = 'TuaChiaveAPI';
    const apiUrl = `https://maps.googleapis.com/maps/api/geocode/json?address=${encodeURIComponent(location)}&key=${apiKey}`;

    return this.http.get(apiUrl)
      .pipe(map((data: any) => {
        if (data.results && data.results.length > 0) {
          const result = data.results[0];
          const coordinates = result.geometry.location;
          return { lat: coordinates.lat, lng: coordinates.lng };
        } else {
          throw new Error('Località non trovata');
        }
      }));
  }

}
