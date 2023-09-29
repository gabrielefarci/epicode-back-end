import { SharedService } from 'src/app/Services/shared.service';
import { Component, ElementRef } from '@angular/core';

@Component({
  selector: 'app-pagina3',
  templateUrl: './pagina3.component.html',
  styleUrls: ['./pagina3.component.css']
})
export class Pagina3Component {

  constructor(protected sharedService: SharedService) {}

}
