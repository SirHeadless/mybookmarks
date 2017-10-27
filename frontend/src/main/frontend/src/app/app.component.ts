import {Component} from '@angular/core';
import {UserService} from './_services/user.service';

@Component({
  moduleId: module.id,
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';
  users;

  constructor(private userService: UserService) {
    this.users = userService.getAll();
  }
}
