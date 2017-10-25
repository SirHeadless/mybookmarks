import {Injectable} from '@angular/core';
import {Headers, Http, RequestOptions, Response} from '@angular/http';

import {User} from '../_models/index';

@Injectable()
export class UserService {
  constructor(private http: Http) {
  }

  getAll() {
    return this.http.get('http://localhost:8080/url/', this.jwt()).map((response: Response) => response.json());
  }

  getById(id: number) {
    return this.http.get('http://localhost:8080/url/' + id, this.jwt()).map((response: Response) => response.json());
  }

  create(user: User) {
    return this.http.post('http://localhost:8080/url/', user, this.jwt()).map((response: Response) => response.json());
  }

  update(user: User) {
    return this.http.put('http://localhost:8080/url/' + user.id, user, this.jwt()).map((response: Response) => response.json());
  }

  delete(id: number) {
    return this.http.delete('http://localhost:8080/url/' + id, this.jwt()).map((response: Response) => response.json());
  }

  // private helper methods

  private jwt() {
    // create authorization header with jwt token
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser && currentUser.token) {
      const headers = new Headers({'Authorization': 'test test'});
      return new RequestOptions({headers: headers});
    }
  }
}
