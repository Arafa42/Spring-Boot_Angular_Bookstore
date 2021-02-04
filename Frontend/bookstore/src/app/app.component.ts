import { Component } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { AuthService } from './services/Authentication/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent
{
  authState: any = null;
  title = 'bookstore';


  constructor(private firebaseAuth: AngularFireAuth)
  {
    this.firebaseAuth.authState.subscribe(authState =>
    {
      this.authState = authState;
    });
  }


  get isAuthenticated(): boolean
  {
    return this.authState !== null;
  }




}

