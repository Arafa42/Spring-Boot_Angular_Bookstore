import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BottomnavigationComponent } from './components/bottomnavigation/bottomnavigation.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { BooksComponent } from './components/books/books.component';
import { AuthorsComponent } from './components/authors/authors.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ApiManagerComponent } from './components/api-manager/api-manager.component';
import { HomeComponent } from './components/home/home.component';



@NgModule({
  declarations: [
    AppComponent,
    BottomnavigationComponent,
    BooksComponent,
    AuthorsComponent,
    ProfileComponent,
    ApiManagerComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CommonModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    MatButtonModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
