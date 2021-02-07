import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Author } from 'src/app/models/Author';
import { Book } from 'src/app/models/Book';
import { Order } from 'src/app/models/Order';
import { User } from 'src/app/models/User';
import { IAuthors } from './IAuthors';
import { IBooks } from './IBooks';
import { IOrders } from './IOrders';
import { IUsers } from './IUsers';

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
    const url = this.requestURL + "/authors/" + id;
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
    const url = this.requestURL + "/books/" + id;
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


  //USERS
  //_______________________________________________

  public getAllUsers()
  {
    const url = this.requestURL + "/users";
    return this.http.get<IUsers[]>(url);
  }

  public getUserById(id: number)
  {
    const url = this.requestURL + "/users/getById/" + id;
    return this.http.get<IUsers>(url);
  }

  public getUserByEmail(email: string)
  {
    const url = this.requestURL + "/users/getByMail/" + email;
    return this.http.get<IUsers>(url);
  }

  public deleteUser(id: number)
  {
    const url = this.requestURL + "/users/" + id;
    return this.http.delete<IUsers>(url);
  }

  public updateUser(email: string, firstName: string, lastName: string, address: string, postcode: number, gemeente: string, gebdatum: string, gender: string)
  {
    const url = this.requestURL + "/users/" + email;
    return this.http.put<any>(url, { firstName: firstName, lastName: lastName, email: email, address: address, postcode: postcode, gemeente: gemeente, gebdatum: gebdatum, gender: gender });
  }

  public createUser(user: User)
  {
    const url = this.requestURL + "/users/createUser";
    return this.http.post<any>(url, user);
  }



  //ORDERS
  //_______________________________________________


  public getOrdersByEmail(email: string)
  {
    const url = this.requestURL + "/orders/getByMail/" + email;
    return this.http.get<IOrders[]>(url);
  }

  public deleteOrder(id: number, email: string)
  {
    const url = this.requestURL + "/orders/" + email + "/" + id;
    return this.http.delete<IOrders>(url);
  }

  public createOrderByMail(order: Order, mail: String)
  {
    const url = this.requestURL + "/orders/createOrder/" + mail;
    return this.http.post<any>(url, order);
  }


}