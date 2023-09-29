import { HttpClient } from '@angular/common/http';
import { Component, ElementRef } from '@angular/core';
import { SharedService } from 'src/app/Services/shared.service';

@Component({
  selector: 'app-pagina8',
  templateUrl: './pagina8.component.html',
  styleUrls: ['./pagina8.component.css']
})
export class Pagina8Component {

  firstImages: File[] = [];
  images: File[] = [];
  uploadedImages: string[] = [];
  initialDropzonesCount = 3;
  dynamicDropzonesCount = this.initialDropzonesCount;
  dropzoneIndices = Array.from({ length: this.initialDropzonesCount }, (_, i) => i);

  constructor(private http: HttpClient, private el: ElementRef, protected sharedService: SharedService) {}

  firstImageDrop(event: any) {
    this.firstImages.push(...event.addedFiles);
    console.log('Immagine caricata:', this.firstImages);
    this.sharedService.uploadedImageUrls = this.firstImages.map(image => URL.createObjectURL(image));
  }

  imagesDrop(event: any) {
    this.images.push(...event.addedFiles);
    console.log('Immagini caricate:', this.images);
    this.uploadedImages = this.images.map(image => URL.createObjectURL(image));
    if (this.uploadedImages.length === 1) {
      const firstDropzone = this.el.nativeElement.querySelector('.box-foto2 ngx-dropzone');
      if (firstDropzone) {
        firstDropzone.remove();
      }
    }
  }

  firstImageRemoved(event: any) {
    this.firstImages.splice(this.firstImages.indexOf(event), 1);
  }

  imagesRemoved(event: any) {
    this.images.splice(this.images.indexOf(event), 1);
  }

  uploadImages() {
    this.sharedService.uploadedImageUrls = [];

    for (const image of this.firstImages) {
      const imageUrl = URL.createObjectURL(image);
      this.sharedService.uploadedImageUrls.push(imageUrl);
    }
    this.firstImages = [];
  }

  addDynamicDropzone() {
    if (this.dynamicDropzonesCount < 10) {
      this.dynamicDropzonesCount++;
      this.dropzoneIndices.push(this.dynamicDropzonesCount - 1);
      console.log("Ho aggiunto un dropzone")
    }
  }

}
