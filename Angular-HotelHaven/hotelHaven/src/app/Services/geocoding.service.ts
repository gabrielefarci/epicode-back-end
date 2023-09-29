import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GeocodingService {

  private apiKey = 'AIzaSyDtEAPXpQJ6RwvKEatZSAvnrOXliE8XzN4';

  constructor(private http: HttpClient) {}

  getAddressSuggestions(query: string): Observable<any> {
    const apiUrl = `https://maps.googleapis.com/maps/api/geocode/json?address=${query}&key=${this.apiKey}`;
    return this.http.get(apiUrl);
  }

}
