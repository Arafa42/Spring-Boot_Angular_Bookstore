import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { BackendService } from 'src/app/services/backend/backend.service';
import { IAuthors } from 'src/app/services/backend/IAuthors';
import { trigger, state, style, transition, animate } from '@angular/animations';

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.scss'],
  animations: [
    trigger('rowExpansionTrigger', [
      state('void', style({
        transform: 'translateX(-10%)',
        opacity: 0
      })),
      state('active', style({
        transform: 'translateX(0)',
        opacity: 1
      })),
      transition('* <=> *', animate('400ms cubic-bezier(0.86, 0, 0.07, 1)'))
    ])
  ]
})
export class AuthorsComponent implements OnInit
{
  allAuthors: IAuthors[] = [];

  constructor(public backendService: BackendService) { }

  ngOnInit(): void
  {
    this.getAllAuthors();
  }

  public getAllAuthors()
  {
    this.backendService.getAllAuthors().subscribe(
      authors =>
      {
        this.allAuthors = authors;
        console.log(this.allAuthors[0].birthDate);
      },
      (error: HttpErrorResponse) =>
      {
        console.log(error);
      }
    );
  }

}
