import { Component } from '@angular/core';

@Component({
  selector: 'app-pagina6',
  templateUrl: './pagina6.component.html',
  styleUrls: ['./pagina6.component.css']
})
export class Pagina6Component {

  count1: number = 1;
  count2: number = 1;
  count3: number = 1;
  count4: number = 1;

  increase1() {
    this.count1++;
  }

  decrease1() {
    if (this.count1 > 0) {
      this.count1--;
    }
  }

  increase2() {
    this.count2++;
  }

  decrease2() {
    if (this.count2 > 0) {
      this.count2--;
    }
  }

  increase3() {
    this.count3++;
  }

  decrease3() {
    if (this.count3 > 0) {
      this.count3--;
    }
  }

  increase4() {
    this.count4 += 0.5;
  }

  decrease4() {
    if (this.count4 > 0) {
      this.count4 -= 0.5;
    }
  }

}
