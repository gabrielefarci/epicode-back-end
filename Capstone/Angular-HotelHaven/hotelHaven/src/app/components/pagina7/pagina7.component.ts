import { Component } from '@angular/core';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-pagina7',
  templateUrl: './pagina7.component.html',
  styleUrls: ['./pagina7.component.css']
})
export class Pagina7Component {

  divs1 = [
    { id: 1, icon: 'wifi', label: 'Wi-fi' },
    { id: 2, icon: 'tv', label: 'TV' },
    { id: 3, icon: 'oven_gen', label: 'Cucina' },
    { id: 4, icon: 'local_laundry_service', label: 'Lavatrice' },
    { id: 5, icon: 'directions_car', label: 'Parcheggio gratuito nella proprietà' },
    { id: 6, icon: '', label: 'Parcheggio a pagamento' },
    { id: 7, icon: 'mode_fan', label: 'Aria condizionata' },
    { id: 8, icon: 'desk', label: 'Spazio di lavoro dedicato' }
  ];

  divs2 = [
    { id: 9, icon: 'pool', label: 'Piscina' },
    { id: 10, icon: '', label: 'Idromassaggio' },
    { id: 11, icon: '', label: 'Patio' },
    { id: 12, icon: 'outdoor_grill', label: 'Griglia per barbecue' },
    { id: 13, icon: 'deck', label: 'Zona pranzo all\'aperto' },
    { id: 14, icon: 'local_fire_department', label: 'Braciere' },
    { id: 15, icon: '', label: 'Tavolo da biliardo' },
    { id: 16, icon: 'fireplace', label: 'Camino' },
    { id: 17, icon: 'piano', label: 'Pianoforte' },
    { id: 18, icon: 'fitness_center', label: 'Attrezzatura sportiva' },
    { id: 19, icon: '', label: 'Accesso al lago' },
    { id: 20, icon: 'beach_access', label: 'Accesso alla spiaggia' },
    { id: 21, icon: 'downhill_skiing', label: 'Accesso alle piste' },
    { id: 22, icon: 'shower', label: 'Doccia all\'aperto' }
  ];

  divs3 = [
    { id: 23, icon: 'detector_smoke', label: 'Allarme antincendio' },
    { id: 24, icon: 'medical_services', label: 'Kit di pronto soccorso' },
    { id: 25, icon: 'fire_extinguisher', label: 'Estintore' },
    { id: 26, icon: 'detector_co', label: 'Rilevatore di monosido di carbonio' }
  ];

  // selectedDiv1: number | null = null;
  // selectedDiv2: number | null = null;
  // selectedDiv3: number | null = null;

  selectedDiv1: number[] = [];
  selectedDiv2: number[] = [];
  selectedDiv3: number[] = [];

  constructor(private sharedService: SharedService) {}

  // onClickDiv1(index: number): void {
  //   this.selectedDiv1 = index;
  //   this.sharedService.setDivSelezionato();
  // }

  // onClickDiv2(index: number): void {
  //   this.selectedDiv2 = index;
  //   this.sharedService.setDivSelezionato();
  // }

  // onClickDiv3(index: number): void {
  //   this.selectedDiv3 = index;
  //   this.sharedService.setDivSelezionato();
  // }

  onClickDiv1(index: number): void {
    const selectedIndex = this.selectedDiv1.indexOf(index);
    if(selectedIndex === -1) {
      this.selectedDiv1.push(index);
    }else {
      this.selectedDiv1.splice(selectedIndex, 1);
    }
    this.sharedService.setDivSelezionato();
  }

  onClickDiv2(index: number): void {
    const selectedIndex = this.selectedDiv2.indexOf(index);
    if(selectedIndex === -1) {
      this.selectedDiv2.push(index);
    }else {
      this.selectedDiv2.splice(selectedIndex, 1);
    }
    this.sharedService.setDivSelezionato();
  }

  onClickDiv3(index: number): void {
    const selectedIndex = this.selectedDiv3.indexOf(index);
    if(selectedIndex === -1) {
      this.selectedDiv3.push(index);
    }else {
      this.selectedDiv3.splice(selectedIndex, 1);
    }
    this.sharedService.setDivSelezionato();
  }

  isDivSelected1(index: number): boolean {
    return this.selectedDiv1.includes(index);
  }

  isDivSelected2(index: number): boolean {
    return this.selectedDiv2.includes(index);
  }

  isDivSelected3(index: number): boolean {
    return this.selectedDiv3.includes(index);
  }

}
