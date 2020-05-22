import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  encapsulation: ViewEncapsulation.None,
  host: { class: 'app-root' },
})
export class AppComponent implements OnInit {
  days = 0;
  people = 100;
  infectChance = 5;
  infectedPeople: boolean[];

  constructor() {}

  ngOnInit() {
    this._calcInfected(this.people, this.infectChance);
  }

  private _calcInfected(people: number, infectChance: number) {
    this.infectedPeople = [];
    for (let i = 0; i < people; i++) {
      if (Math.random() * 100 < infectChance) {
        this.infectedPeople.push(true);
      } else {
        this.infectedPeople.push(false);
      }
    }
  }

  setPeople() {
    this._calcInfected(this.people, this.infectChance);
  }

  infectAllPeople(infectedPeople: boolean[]) {
    if (infectedPeople.filter((x) => !x).length !== 0) {
      this.days++;
      setTimeout(() => {
        for (let i = 0; i < this.infectedPeople.length; i++) {
          if (!infectedPeople[i]) {
            continue;
          }
          if (i === 0 && infectedPeople[0]) {
            if (!infectedPeople[i + 1]) {
              i++;
              infectedPeople[i] = true;
            }
            continue;
          }
          if (!infectedPeople[i - 1]) {
            infectedPeople[i - 1] = true;
          }
          if (i + 1 < infectedPeople.length && !infectedPeople[i + 1]) {
            infectedPeople[i + 1] = true;
            i++;
          }
        }
        this.infectedPeople = infectedPeople;
        return this.infectAllPeople(infectedPeople);
      }, 300);
    } else {
    }
  }
}
