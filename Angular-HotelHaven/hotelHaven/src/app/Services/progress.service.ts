import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProgressService {

  constructor() { }

  private progressValue: number = 0;

  getProgress(): number {
    return this.progressValue;
  }

  setProgress(value: number): void {
    this.progressValue = value;
  }

}
