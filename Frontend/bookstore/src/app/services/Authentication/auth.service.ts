import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { LocalStorageManager } from 'src/app/other/LocalStorageManager';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService
{

  authState: any = null;
  IsLoggedIn: boolean = false;
  CurrentUser: String = "";
  CurrentEmail: string = "";

  constructor(private firebaseAuth: AngularFireAuth, public router: Router)
  {

    this.firebaseAuth.authState.subscribe(authState =>
    {
      this.authState = authState;
    });

  }


  SignUp(email: string, password: string)
  {
    this.firebaseAuth.createUserWithEmailAndPassword(email, password)
      .then(value =>
      {
        this.IsLoggedIn = true;
        this.GetCurrentEmail();
        this.router.navigateByUrl("home");
        console.log(value);
      })
      .catch(err =>
      {
        console.log(err.message);

      });
  }

  Login(email: string, password: string)
  {
    this.firebaseAuth.signInWithEmailAndPassword(email, password)
      .then(value =>
      {
        this.router.navigateByUrl("home");
        LocalStorageManager.SetCurrentMail(email);
        this.GetCurrentEmail();
        this.IsLoggedIn = true;
        console.log(this.GetCurrentEmail());
      })
      .catch(err =>
      {
        console.log(err.message);
      });
  }

  Logout()
  {
    this.router.navigate(['/login']);
    this.IsLoggedIn = false;
    this.CurrentEmail = "";
    this.firebaseAuth.signOut();
    LocalStorageManager.SetCurrentMail("");
  }


  get isAuthenticated(): boolean
  {
    return this.authState !== null;
  }

  GetCurrentEmail()
  {
    if (!this.isAuthenticated) {
      return [];
    }
    return this.authState.email;

  }








}
