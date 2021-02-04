import { Component, OnInit } from '@angular/core';
import { Message, MessageService, PrimeNGConfig, SelectItem } from 'primeng/api';
import { Book } from 'src/app/models/Book';
import { BackendService } from 'src/app/services/backend/backend.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss'],
  providers: [MessageService]

})
export class BooksComponent implements OnInit
{

  allBooks: Book[] = [];
  sortOptions: SelectItem[];
  sortOrder: number;
  sortField: string;
  sortKey: string;


  constructor(public backendService: BackendService, private messageService: MessageService, private primengConfig: PrimeNGConfig) { }


  ngOnInit(): void
  {

    this.sortOptions = [
      { label: 'Price High to Low', value: '!price' },
      { label: 'Price Low to High', value: 'price' }
    ];
    this.primengConfig.ripple = true;
    this.getAllBooks();
  }


  showSuccess()
  {
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Book added to basket' });
  }


  public getAllBooks()
  {
    this.backendService.getAllBooks().subscribe(
      books =>
      {
        this.allBooks = books;
      },
      error =>
      {
        console.log(error);
      }
    );
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

  onSortChange(event)
  {
    let value = event.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    }
    else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }




}
