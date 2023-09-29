import { Component, OnDestroy } from '@angular/core';
import { ProgressService } from 'src/app/Services/progress.service';
import { SharedService } from 'src/app/Services/shared.service';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-add-home',
  templateUrl: './add-home.component.html',
  styleUrls: ['./add-home.component.css']
})
export class AddHomeComponent implements OnDestroy {

  constructor(private progressService: ProgressService, private appComponent: AppComponent, protected sharedService: SharedService) {
    this.appComponent.isAddHomeVisible = true;
  }

  ngOnDestroy() {
    this.appComponent.isAddHomeVisible = false;
  }

  getProgress(): number {
    return this.progressService.getProgress();
  }

  // Avanza il progresso di 10
  goForward(): void {
    const currentProgress = this.progressService.getProgress();
    this.progressService.setProgress(currentProgress + 10);
  }

  // Torna indietro nel progresso di 10
  goBackward(): void {
    const currentProgress = this.progressService.getProgress();
    this.progressService.setProgress(currentProgress - 10);
  }

}
