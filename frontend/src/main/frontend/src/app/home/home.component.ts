import {Component, OnInit} from '@angular/core';

import {User} from '../_models/index';
import {Url} from '../_models/index';
import {UserService} from '../_services/index';
import {UrlService} from "../_services/url.service"

@Component({
  moduleId: module.id,
  templateUrl: 'home.component.html'
})

export class HomeComponent implements OnInit {
  currentUser: User;
  urls: Url[] = [];
  // private urlService: UrlService;

  constructor(private urlService: UrlService) {
  }

  ngOnInit() {
    this.loadAllUrls();
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  // deleteUser(id: number) {
  //   this.userService.delete(id).subscribe(() => {
  //     this.loadAllUsers();
  //   });
  // }

  private loadAllUrls() {
    this.urlService.getAll().subscribe(urls => {
      debugger;
      console.log("============ ALL USERS: ===============")
      console.log(urls);
      this.urls = urls;
    });
  }
}
