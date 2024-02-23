import { Component } from '@angular/core';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.scss']
})
export class ServicesComponent {

  cards = [
    { id: 0, img: 'bi-window-sidebar', title: 'Desarrollo de software', desc: 'Diseñamos y creamos aplicaciones según las necesidades del proyecto, ayudando así, a automatizar y mejorar tus procesos con tecnologías modernas.'},
    { id: 1, img: 'bi-phone', title: 'Desarrollo de apps moviles', desc: 'Creamos aplicaciones móviles para diferentes plataformas, para colocar tu proyecto en cualquier dispositivo móvil.'},
    { id: 2, img: 'bi-chat-left-dots', title: 'Consultoria especializada', desc: 'Rediseñamos y migramos cualquier aplicación o sistema con las tecnologías más modernas.'},
  ]

}
