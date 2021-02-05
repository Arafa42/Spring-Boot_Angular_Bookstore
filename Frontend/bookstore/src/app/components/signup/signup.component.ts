import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FirebaseApp } from '@angular/fire';
import { AngularFireAuth } from '@angular/fire/auth';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { User } from 'src/app/models/User';
import { AuthService } from 'src/app/services/Authentication/auth.service';
import { BackendService } from 'src/app/services/backend/backend.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss'],
})
export class SignupComponent implements OnInit
{
  authState: any = null;

  UserDataToUpload: User = {
    firstName: "",
    lastName: "",
    email: "",
    address: "",
    postcode: 1111,
    gemeente: "",
    gebdatum: "",
    gender: ""
  };

  constructor(public backendService: BackendService, private authService: AuthService, private firebaseAuth: AngularFireAuth, private router: Router)
  {
    this.firebaseAuth.authState.subscribe(authState =>
    {
      this.authState = authState;
    });
  }

  ngOnInit(): void
  {
  }


  onChange(selected)
  {
    console.log(selected);
  }




  async signUp(form): Promise<void>
  {
    await this.authService.SignUp(form.value.email, form.value.password);
    console.log(this.authService.isAuthenticated);
  }


  PostNewUserData()
  {
    if (!this.authService.fail) {
      this.backendService.createUser(this.UserDataToUpload).subscribe(
        data =>
        {
          console.log(data);
        },
        (error: HttpErrorResponse) =>
        {
          console.log(error);
        }

      );
    }
    else {
      console.log("error...");
    }
  }

}
