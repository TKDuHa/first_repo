import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {
  animals: Object;

  //new Animal
  animal: Object;

  constructor(private _http: HttpService) {}

  ngOnInit(): void {
    this._http.getAnimals().subscribe((data) => {
      this.animals = data;
      console.log(this.animals);
    });
  }

  addAnimal(): void {
    this._http.addAdnimal.apply({
      name: this.name,
      race: this.race,
      age: this.age,
      parent: this.parent,
    });
  }
}
