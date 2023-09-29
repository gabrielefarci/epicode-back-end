import { SharedService } from 'src/app/Services/shared.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-pagina9',
  templateUrl: './pagina9.component.html',
  styleUrls: ['./pagina9.component.css']
})
export class Pagina9Component {

  count:number = 0;

  constructor(private sharedService: SharedService) {}

  onInputChange(event: Event): void {
    const textareaValue = (event.target as HTMLTextAreaElement).value;
    this.count = textareaValue.length;
    this.sharedService.isButtonDisabled2 = this.count === 0;
  }

}
