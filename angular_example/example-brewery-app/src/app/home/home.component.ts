import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  clickCounter: number = 0;
  name: string = '';

  constructor() {}

  ngOnInit(): void {}

  countClick() {
    this.clickCounter += 1;
  }

  setCounterStyleClass() {
    let myCounterStyleClass = {
      greatcounter: this.clickCounter > 4,
      lesscounter: this.clickCounter <= 4,
    };
    return myCounterStyleClass;
  }
}
