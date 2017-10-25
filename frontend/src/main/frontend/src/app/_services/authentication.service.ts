import {Injectable} from '@angular/core';
import {Headers, Http, RequestOptions, Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }

    login(username: string, password: string) {

        debugger;
        return this.http.get('http://localhost:8080/url/', this.jwt(username, password))
           // JSON.stringify({ username: username, password: password }))

            .map((response: Response) => {
                debugger;
                // login successful if there's a jwt token in the response
                const user = response.json();
                if (user && user.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                return user;
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }

    private jwt(username: string, password: string) {

      // const headers = new Headers({'Authorization': username + ' ' + password, 'Access-Control-Allow-Origin':"http://localhost:4200"});
        const headers = new Headers({ 'Authorization': 'Basic ' + btoa(username + ':' + password)});
//         const headers = new Headers({ 'Authorization': 'Bearer ' + btoa(username + ':' + password)});
//        const headers = {'Authorization': 'Basic ' + btoa(username + ':' + password)};
        console.log(headers);
//                  headers.append('Access-Control-Allow-Origin', 'http://localhost:8080');
        return new RequestOptions({ headers: headers });
//      return { headers: headers };
    }
}

