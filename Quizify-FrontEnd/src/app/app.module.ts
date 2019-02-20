
import { QuizifyModule } from './quizify/quizify.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule}from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { QuestionService } from './quizify/services/question.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    QuizifyModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
providers: [
QuestionService
],
  bootstrap: [AppComponent]
})
export class AppModule { }
