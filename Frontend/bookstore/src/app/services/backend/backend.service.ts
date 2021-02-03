import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Author } from 'src/app/models/Author';
import { Book } from 'src/app/models/Book';
import { IAuthors } from './IAuthors';
import { IBooks } from './IBooks';

@Injectable({
  providedIn: 'root'
})
export class BackendService
{
  requestURL: string = "http://localhost:8080/api/v1";

  constructor(private http: HttpClient) { }


  //AUTHORS
  //______________________________________________________

  public getAllAuthors()
  {
    const url = this.requestURL + "/authors";
    return this.http.get<IAuthors[]>(url);
  }

  public getAuthor(id: number)
  {
    const url = this.requestURL + "/authors/" + id;
    return this.http.get<IAuthors>(url);
  }

  public deleteAuthor(id: number)
  {
    const url = this.requestURL + "/authors" + id;
    return this.http.delete<IAuthors>(url);
  }

  public updateAuthor(id: number, firstName: string, lastName: string, birthDate: string, lifeDescription: string, authorImageURL: string)
  {
    const url = this.requestURL + "/authors/" + id;
    return this.http.put<any>(url, { firstName: firstName, lastName: lastName, birthdate: birthDate, lifeDescription: lifeDescription, authorImageURL: authorImageURL });
  }

  public createAuthor(author: Author)
  {
    const url = this.requestURL + "/authors";
    return this.http.post<any>(url, author);
  }


  //BOOKS
  //________________________________________________________


  public getAllBooks()
  {
    const url = this.requestURL + "/books";
    return this.http.get<IBooks[]>(url);
  }

  public getBook(id: number)
  {
    const url = this.requestURL + "/books/" + id;
    return this.http.get<IBooks>(url);
  }

  public deleteBook(id: number)
  {
    const url = this.requestURL + "/books" + id;
    return this.http.delete<IBooks>(url);
  }

  public updateBook(id: number, bookName: string, author: string, pages: number, isbn: number, category: string, coverURL: string, summary: string, price: number, rating: number)
  {
    const url = this.requestURL + "/books/" + id;
    return this.http.put<any>(url, { bookName: bookName, author: author, pages: pages, isbn: isbn, category: category, coverURL: coverURL, summary: summary, price: price, rating: rating });
  }

  public createBook(book: Book)
  {
    const url = this.requestURL + "/books";
    return this.http.post<any>(url, book);
  }


}