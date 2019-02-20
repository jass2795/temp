import { NgModule } from '@angular/core';
import {MatCardModule}from '@angular/material/card';
import {MatButtonModule}from '@angular/material/button';
import {
MatIconModule,
MatGridListModule,
MatChipsModule,
MatSelectModule,
MatCheckboxModule,
MatTableModule,
MatInputModule,
MatRadioModule
}from '@angular/material';
import {MatToolbarModule}from '@angular/material/toolbar';
import {MatMenuModule}from '@angular/material/menu';
import {MatTooltipModule}from '@angular/material/tooltip';
import {MatSnackBarModule}from '@angular/material/snack-bar';
import {MatFormFieldModule}from '@angular/material/form-field';
import {MatDialogModule}from '@angular/material/dialog';
import {MatSidenavModule}from '@angular/material/sidenav';
import {MatListModule}from '@angular/material/list';
import { FormsModule } from '@angular/forms';
import {FlexLayoutModule}from '@angular/flex-layout';



@NgModule({
    declarations: [],
    imports: [
MatCardModule,
      MatButtonModule,
      MatIconModule,
      MatToolbarModule,
      MatMenuModule,
      MatFormFieldModule,
MatInputModule,
MatTooltipModule,
MatSnackBarModule,
MatDialogModule,
MatSidenavModule,
MatListModule,
MatGridListModule,
MatRadioModule,
MatChipsModule,
MatSelectModule,
FlexLayoutModule,
MatCheckboxModule,
MatTableModule,
FormsModule
      ] ,
      exports: [
        MatCardModule,
        MatButtonModule,
        MatIconModule,
        MatToolbarModule,
        MatMenuModule,
MatFormFieldModule,
MatInputModule,
MatTooltipModule,
MatSnackBarModule,
MatDialogModule,
MatSidenavModule,
MatListModule,
MatGridListModule,
MatRadioModule,
MatChipsModule,
MatSelectModule,
FlexLayoutModule,
MatCheckboxModule,
MatTableModule,
FormsModule
         ]

   })
  export class QuizifyMaterialModule { }
