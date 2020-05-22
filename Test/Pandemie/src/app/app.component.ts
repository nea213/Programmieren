import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ResultDialogComponent, IData } from './dialog/dialog.component';

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
  isCalculating = false;

  constructor(private _dialog: MatDialog) {}

  ngOnInit() {
    this._calcInfectedFirstTime(this.people, this.infectChance);
  }

  openDialog() {
    this._dialog.open(ResultDialogComponent, {
      data: {
        days: this.days,
        people: this.people,
      } as IData,
    });
  }

  setPeople() {
    this._calcInfectedFirstTime(this.people, this.infectChance);
  }

  infectAllPeople(infectedPeople: boolean[]) {
    if (infectedPeople.filter((x) => !x).length !== 0) {
      infectedPeople = this._calcInfectedOnTurn(
        infectedPeople,
        this.infectChance
      );
      this.isCalculating = true;
      this.days++;
      setTimeout(() => {
        for (let i = 0; i < infectedPeople.length; i++) {
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
      this.isCalculating = false;
      this.openDialog();
    }
  }

  private _calcInfectedFirstTime(people: number, infectChance: number) {
    this.days = 0;
    this.infectedPeople = [];
    for (let i = 0; i < people; i++) {
      if (Math.random() * 100 < infectChance) {
        this.infectedPeople.push(true);
      } else {
        this.infectedPeople.push(false);
      }
    }
  }

  private _calcInfectedOnTurn(
    infectedPeople: boolean[],
    infectChance: number
  ): boolean[] {
    for (let i = 0; i < infectedPeople.length; i++) {
      if (!infectedPeople[i]) {
        if (Math.random() * 100 < infectChance) {
          infectedPeople[i] = true;
        }
      }
    }
    return infectedPeople;
  }
}
