import { Component, OnInit } from '@angular/core';
import { CityService } from 'src/app/Services/city.service';

@Component({
  selector: 'app-cities',
  templateUrl: './cities.component.html',
  styleUrls: ['./cities.component.css']
})
export class CitiesComponent implements OnInit {

  cities!: any[];

  constructor(private cityService: CityService) {}

  ngOnInit(): void {
    this.cityService.getCitiesFromCsv()
      .then(() => {
        this.cities = this.cityService.getAllCities();
      });
  }

}
