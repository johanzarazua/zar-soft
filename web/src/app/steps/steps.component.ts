import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-steps',
  templateUrl: './steps.component.html',
  styleUrls: ['./steps.component.scss']
})
export class StepsComponent implements OnInit {
  ngOnInit(): void {
    
  }

  steps = [
    { id: 1, title: "Análisis y diseño", desc: "Analizamos tus necesidades a detalle, para entender los procesos y diseñar la estructura de software de manera óptima, separando los requerimientos en módulos."},
    { id: 2, title: "UX/UI", desc: "Diseñamos las pantallas con las cuales interactúa el usuario, para lograr una experiencia adecuada."},
    { id: 3, title: "Construccion", desc: "Realizamos la construcción del proyecto por módulos, generando el código necesario para crear una aplicación funcional." },
    { id: 4, title: "Pruebas", desc: "Comprobamos la funcionalidad de cada módulo para garantizar una alta calidad y posteriormente integrarlos con otros módulos. Finalmente realizamos pruebas de integración para comprobar el correcto funcionamiento en conjunto." },
    { id: 5, title: "Implementacion y entrega", desc: "Una vez creada la aplicación, la instalamos en el entorno deseado y realizamos la entrega de su proyecto." },
  ]
}
