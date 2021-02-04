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
  providers: [MessageService]

})
export class SignupComponent implements OnInit
{
  authState: any = null;

  UserDataToUpload: User = {
    firstName: "",
    lastName: "",
    email: "",
    address: "",
    postcode: 0,
    gemeente: "",
    gebdatum: "",
    gender: ""
  };

  constructor(public backendService: BackendService, private messageService: MessageService, private authService: AuthService, private firebaseAuth: AngularFireAuth, private router: Router)
  {
    this.firebaseAuth.authState.subscribe(authState =>
    {
      this.authState = authState;
    });
  }

  ngOnInit(): void
  {
  }

  get isAuthenticated(): boolean
  {
    return this.authState !== null;
  }

  onChange(selected)
  {
    console.log(selected);
  }

  showSticky()
  {
    this.messageService.add({ severity: 'info', summary: 'Sticky', detail: 'Message Content', sticky: true });
  }

  onConfirm()
  {
    this.messageService.clear('c');
  }

  onReject()
  {
    this.messageService.clear('c');
  }

  clear()
  {
    this.messageService.clear();
  }

  showSuccess()
  {
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'User created' });
  }

  showFailure()
  {
    this.messageService.add({ severity: 'error', summary: 'Error', detail: 'email not valid or already in use' });
  }



  async signUp(form): Promise<void>
  {
    await this.authService.SignUp(form.value.email, form.value.password);
  }


  PostData()
  {
    if (this.authService.IsLoggedIn) {
      this.PostNewUserData();
      this.showSuccess();
    }
  }



  PostNewUserData()
  {
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

}
