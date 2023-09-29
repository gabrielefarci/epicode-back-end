import { Component } from '@angular/core';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-pagina2',
  templateUrl: './pagina2.component.html',
  styleUrls: ['./pagina2.component.css']
})
export class Pagina2Component {

  divs = [
    { id: 1, icon: './../../../assets/house-svgrepo-com.svg', label: 'Casa' },
    { id: 2, icon: './../../../assets/apartment-left-svgrepo-com.svg', label: 'Appartamento' },
    { id: 3, icon: './../../../assets/tea-cup-svgrepo-com.svg', label: 'B&B' },
    { id: 4, icon: './../../../assets/wooden-house-svgrepo-com.svg', label: 'Baita' },
    { id: 5, icon: './../../../assets/caravan-svgrepo-com.svg', label: 'Camper o Roulotte' },
    { id: 6, icon: './../../../assets/farm-svgrepo-com.svg', label: 'Fattoria' },
    { id: 7, icon: './../../../assets/tree-house-svgrepo-com.svg', label: 'Casa sull\'albero' },
    { id: 8, icon: './../../../assets/trullo-svgrepo-com.svg', label: 'Trullo' }
  ];

  constructor(protected sharedService: SharedService) {}

  onClickDiv(index: number): void {
    this.sharedService.selectedDiv2 = index;
    this.sharedService.setDivSelezionato();
  }

}
