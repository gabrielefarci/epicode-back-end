import { Component, OnInit } from '@angular/core';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-pagina10',
  templateUrl: './pagina10.component.html',
  styleUrls: ['./pagina10.component.css']
})
export class Pagina10Component implements OnInit {

  count:number = 0;
  textareaValue = 'Soggiorna e divertiti in questo comodo alloggio.';

  constructor() {}

  ngOnInit(): void {
    this.count = this.textareaValue.length;
  }

  onInputChange(event: Event): void {
    const textareaValue = (event.target as HTMLTextAreaElement).value;
    this.count = textareaValue.length;
  }

}
