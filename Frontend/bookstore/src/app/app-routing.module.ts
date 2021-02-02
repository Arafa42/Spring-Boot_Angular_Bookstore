import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ApiManagerComponent } from './components/api-manager/api-manager.component';
import { AuthorsComponent } from './components/authors/authors.component';
import { BooksComponent } from './components/books/books.component';
import { BottomnavigationComponent } from './components/bottomnavigation/bottomnavigation.component';
import { ProfileComponent } from './components/profile/profile.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [

  { path: "home", component: HomeComponent },
  { path: "books", component: BooksComponent },
  { path: "authors", component: AuthorsComponent },
  { path: "profile", component: ProfileComponent },
  { path: "api-manager", component: ApiManagerComponent },
  { path: "", redirectTo: "home", pathMatch: "full" },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
