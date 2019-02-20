import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { QuestionGeneratorComponent } from './quizify/components/question-generator/question-generator.component';

const routes: Routes = [
{path: 'question', component: QuestionGeneratorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
