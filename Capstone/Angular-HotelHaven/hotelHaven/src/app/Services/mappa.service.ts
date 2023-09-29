import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MappaService {

  private googleMapsApiKey = 'AIzaSyCtgOIqICM3zSoY4KXd0CjY7ebKW1HovSU';

  constructor() {}

  getStaticMapUrl(location: string, zoom: number, width: number, height: number): string {
    const baseUrl = 'https://maps.googleapis.com/maps/api/staticmap';
    const params = `center=${location}&zoom=${zoom}&size=${width}x${height}&key=${this.googleMapsApiKey}`;
    return `${baseUrl}?${params}`;
  }

}
