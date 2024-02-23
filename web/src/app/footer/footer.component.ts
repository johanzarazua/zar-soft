import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent {
  contacts = [
    { href: 'https://www.facebook.com/people/ZarSoft/100070710405578/?mibextid=LQQJ4d', img: 'assets/facebook.png', title: 'facebook' },
    { href: 'https://wa.me/7298508286?text=Hola,%20tengo%20en%20mente%20el%20siguiente%20proyecto...', img: 'assets/whatsapp.png', title: 'whatsapp' },
    { href: 'https://www.instagram.com/zar.soft/', img: 'assets/instagram.png', title: 'instagram' },
  ];
}
