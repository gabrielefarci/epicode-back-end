import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  private cities: any[] = [];

  constructor(private http: HttpClient) { }

  getCitiesFromCsv(): Promise<void> {
    const csvUrl = 'assets/cities.csv';
    return this.http.get(csvUrl, { responseType: 'text' })
      .toPromise()
      .then((data: string | undefined) => {
        if (data) {
          this.cities = this.parseCsv(data);
        } else {
          console.error('Il file CSV è vuoto o non esiste.');
        }
      })
      .catch(error => {
        console.error('Errore durante il caricamento del file CSV', error);
      });
  }

  private parseCsv(csvData: string): any[] {
    const rows = csvData.split('\n');
    const cities = [];

    for (let i = 1; i < rows.length; i++) {
      const columns = rows[i].split(',');
      if (columns.length >= 2) {
        const city = {
          name: columns[0].trim(),
          country: columns[1].trim()
        };
        cities.push(city);
      }
    }
    return cities;
  }

  getAllCities() {
    return this.cities;
  }

}
