import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  constructor(private http: HttpClient) {}

  getAnimals() {
    return this.http.get('http://localhost:8080/animal');
  }

  addAdnimal(animal) {
    console.log('Add: ' + animal);
    return this.http.post('http://localhost:8080/animal', animal);
  }
}
