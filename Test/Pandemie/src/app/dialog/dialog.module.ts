import { NgModule } from '@angular/core';
import { ResultDialogComponent } from './dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [CommonModule, MatDialogModule],
  declarations: [ResultDialogComponent],
  exports: [ResultDialogComponent],
})
export class ResultDialogModule {}
