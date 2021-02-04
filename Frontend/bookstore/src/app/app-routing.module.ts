import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AuthorsComponent } from './components/authors/authors.component';
import { BooksComponent } from './components/books/books.component';
import { BottomnavigationComponent } from './components/bottomnavigation/bottomnavigation.component';
import { ProfileComponent } from './components/profile/profile.component';
import { HomeComponent } from './components/home/home.component';
import { BasketComponent } from './components/basket/basket.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';


const routes: Routes = [

  { path: "home", component: HomeComponent },
  { path: "books", component: BooksComponent },
  { path: "authors", component: AuthorsComponent },
  { path: "profile", component: ProfileComponent },
  { path: "basket", component: BasketComponent },
  { path: "login", component: SigninComponent },
  { path: "signup", component: SignupComponent },
  { path: "", redirectTo: "signup", pathMatch: "full" },
  { path: "**", redirectTo: "signup", pathMatch: "full" },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
