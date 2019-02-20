import { QuizifyMaterialModule } from './quizify.material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule}from '@angular/common/http';
import { QuestionGeneratorComponent } from './components/question-generator/question-generator.component';

import { BrowserModule } from '@angular/platform-browser';
@NgModule({
declarations: [
QuestionGeneratorComponent
     ],

  imports: [
    CommonModule,
    BrowserAnimationsModule,
    QuizifyMaterialModule,
    BrowserModule,
    HttpClientModule
  ],
exports: [
QuestionGeneratorComponent
   ]

})
export class QuizifyModule { }
