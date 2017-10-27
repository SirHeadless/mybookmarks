﻿import {Component, OnInit} from '@angular/core';

import {User} from '../_models/index';
import {UserService} from '../_services/index';

@Component({
  moduleId: module.id,
  templateUrl: 'home.component.html'
})

export class HomeComponent implements OnInit {
  currentUser: User;
  users: User[] = [];

  constructor(private userService: UserService) {
    debugger;
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.loadAllUsers();
  }

  deleteUser(id: number) {
    this.userService.delete(id).subscribe(() => {
      this.loadAllUsers();
    });
  }

  private loadAllUsers() {
    this.userService.getAll().subscribe(users => {
      debugger;
      console.log("============ ALL USERS: ===============")
      console.log(users);
      this.users = users;
    });
  }
}
