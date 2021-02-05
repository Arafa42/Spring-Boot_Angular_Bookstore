import { Component, OnInit } from '@angular/core';
import { Local } from 'protractor/built/driverProviders';
import { User } from 'src/app/models/User';
import { LocalStorageManager } from 'src/app/other/LocalStorageManager';
import { AuthService } from 'src/app/services/Authentication/auth.service';
import { BackendService } from 'src/app/services/backend/backend.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit
{

  profileData: User = {
    firstName: "",
    lastName: "",
    email: "",
    address: "",
    postcode: 0,
    gemeente: "",
    gebdatum: "",
    gender: ""
  };

  constructor(public AuthService: AuthService, public backendService: BackendService) { }

  ngOnInit(): void
  {
    this.getLoggedInUser(LocalStorageManager.GetCurrentMail());
    console.log(LocalStorageManager.GetCurrentMail());
  }



  getLoggedInUser(email: string)
  {
    this.backendService.getUserByEmail(email).subscribe(
      user =>
      {
        this.profileData = user;
      },
      error =>
      {
        console.log(error);
      }
    );
  }


  logOut()
  {
    this.AuthService.Logout();
  }


}
