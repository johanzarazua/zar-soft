import { Component } from '@angular/core';

@Component({
  selector: 'app-tecnologies',
  templateUrl: './tecnologies.component.html',
  styleUrls: ['./tecnologies.component.scss']
})
export class TecnologiesComponent {

  imgSize = "80px";

  slides = [
    { img: 'assets/java.png', title: 'java' },
    { img: 'assets/springboot.png', title: 'springboot' },
    { img: 'assets/android.png', title: 'android' },

    { img: 'assets/angular.png', title: 'angular' },
    { img: 'assets/js.png', title: 'javascript' },
    { img: 'assets/ts.png', title: 'typescript' },

    { img: 'assets/c++.png', title: 'c++' },
    { img: 'assets/csharp.png', title: 'c#' },
    { img: 'assets/netcore.png', title: 'net' },

    { img: 'assets/php.png', title: 'php' },
    { img: 'assets/laravel.png', title: 'laravel' },
    { img: 'assets/phpMyAdmin.png', title: 'phpMyAdmin' },

    { img: 'assets/oracle.png', title: 'oracle db' },
    { img: 'assets/sqlServer.png', title: 'sql server' },
    { img: 'assets/mysql.png', title: 'mysql' },

  ];

  getSlides(index: number) {
    return [
      { item: this.slides[3 * index] },
      { item: this.slides[3 * index + 1] },
      { item: this.slides[3 * index + 2] }];
  }

  getLengthSlides(slidesLength: number) {
    return Math.ceil(slidesLength / 3);
  }

}
