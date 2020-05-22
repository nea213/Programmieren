import { Component, Inject, OnInit, ViewEncapsulation } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

export interface IData {
  days: number;
  people: number;
}

@Component({
  selector: 'result-dialog',
  templateUrl: 'dialog.component.html',
  styleUrls: ['dialog.component.scss'],
  encapsulation: ViewEncapsulation.None,
  host: { class: 'dialog' },
})
export class ResultDialogComponent implements OnInit {
  text = '';

  constructor(
    private _dialogRef: MatDialogRef<ResultDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: IData
  ) {}

  ngOnInit() {
    this.text = `Es wurden alle ${this.data.people} Menschen nach ${this.data.days} Tagen infiziert`;
  }
}
