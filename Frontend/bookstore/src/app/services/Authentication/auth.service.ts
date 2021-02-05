import { Component, Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { LocalStorageManager } from 'src/app/other/LocalStorageManager';
import { Observable } from 'rxjs';
import { SnackbarService } from 'src/app/services/Snackbar/snackbar.service';


@Injectable({
  providedIn: 'root'
})

export class AuthService
{

  authState: any = null;
  IsLoggedIn: boolean = false;
  CurrentUser: String = "";
  CurrentEmail: string = "";
  signUpSucces: boolean = false;
  fail: boolean = false;

  constructor(private firebaseAuth: AngularFireAuth, public router: Router, public snackBarService: SnackbarService)
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
        this.signUpSucces = true;
        this.IsLoggedIn = true;
        LocalStorageManager.SetCurrentMail(email);
        this.GetCurrentEmail();
        this.router.navigateByUrl("home");
        console.log(value);
        this.snackBarService.ShowSuccesMessage("Account registered succesfully");
      })
      .catch(err =>
      {
        console.log(err.message);
        this.snackBarService.ShowErrorMessage("An error occured with the registration");
        this.fail = true;

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
        this.snackBarService.ShowSuccesMessage("Succesfully logged in");
      })
      .catch(err =>
      {
        console.log(err.message);
        this.snackBarService.ShowErrorMessage("an error occured with the login");
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
