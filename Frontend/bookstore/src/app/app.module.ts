import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BottomnavigationComponent } from './components/bottomnavigation/bottomnavigation.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { BooksComponent } from './components/books/books.component';
import { AuthorsComponent } from './components/authors/authors.component';
import { ProfileComponent } from './components/profile/profile.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { DataViewModule } from 'primeng/dataview';
import { DropdownModule } from 'primeng/dropdown';
import { RatingModule } from 'primeng/rating';
import { ButtonModule } from 'primeng/button';
import { OrderListModule } from 'primeng/orderlist';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { CalendarModule } from 'primeng/calendar';
import { SliderModule } from 'primeng/slider';
import { MultiSelectModule } from 'primeng/multiselect';
import { ContextMenuModule } from 'primeng/contextmenu';
import { DialogModule } from 'primeng/dialog';
import { ProgressBarModule } from 'primeng/progressbar';
import { InputTextModule } from 'primeng/inputtext';
import { MessagesModule } from 'primeng/messages';
import { BasketComponent } from './components/basket/basket.component';
import { RippleModule } from 'primeng/ripple';
import { AngularFireModule } from '@angular/fire';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

@NgModule({
  declarations: [
    AppComponent,
    BottomnavigationComponent,
    BooksComponent,
    AuthorsComponent,
    ProfileComponent,
    HomeComponent,
    BasketComponent,
    SigninComponent,
    SignupComponent
  ],
  imports: [
    AngularFireModule.initializeApp({
      apiKey: "AIzaSyB-dKjnq0Vp3-i7atFMapZckshl32Nlscw",
      authDomain: "bookstore-6ea4b.firebaseapp.com",
      projectId: "bookstore-6ea4b",
      storageBucket: "bookstore-6ea4b.appspot.com",
      messagingSenderId: "361792797791",
      appId: "1:361792797791:web:585bc07578552c2c40efea",
      measurementId: "G-J677R7SKS7"
    }),
    BrowserModule,
    ToastModule,
    ButtonModule,
    RippleModule,
    FormsModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    CommonModule,
    MatIconModule,
    MatSnackBarModule,
    MessagesModule,
    DataViewModule,
    BrowserAnimationsModule,
    TableModule,
    CalendarModule,
    SliderModule,
    DialogModule,
    MultiSelectModule,
    ContextMenuModule,
    DropdownModule,
    ButtonModule,
    ToastModule,
    InputTextModule,
    ProgressBarModule,
    DropdownModule,
    RatingModule,
    OrderListModule,
    ButtonModule,
    HttpClientModule,
    MatCardModule,
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
