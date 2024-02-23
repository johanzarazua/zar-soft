import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { environment } from 'src/environments/environment';
import Swal from 'sweetalert2';
import { Numverify } from '../numverify';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent {
  options = [
    { value: "", desc: "Seleccione un codigo de pais", flag: "" }
  ]

  charCount = 500;

  ngOnInit(): void {
    this.loadOptions();
  }

  contactForm = new FormGroup({
    name: new FormControl('', [
      Validators.required,
      Validators.pattern('[\\sA-Za-z]*'),
      Validators.maxLength(100)
    ]),
    email: new FormControl('', [
      Validators.required,
      Validators.email,
      Validators.maxLength(500)
    ]),
    country: new FormControl('', [
      Validators.required
    ]),
    phone: new FormControl({ value: '', disabled: true }, [
      Validators.required,
      Validators.pattern('[0-9]{10}')
    ]),
    description: new FormControl('', [
      Validators.required,
      Validators.maxLength(500)
    ])
  });

  public onSubmit(): void {
    console.warn(this.contactForm.value);

    this.numverifyApi(this.contactForm.get("phone")?.value, this.contactForm.get("country")?.value).then(numverify => {

      if (numverify.error === "true") {
        this.saveForm(this.contactForm.value, false);
      } else {
        this.saveForm(this.contactForm.value, true);
      }

    });

  }

  private async saveForm(value: Partial<{ name: string | null; email: string | null; country: string | null; phone: string | null; description: string | null; }>, phoneVerify: boolean) {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var body = JSON.stringify({
      "nombre": value.name,
      "email": value.email,
      "phone": value.phone,
      "phoneVerify": phoneVerify ? "V" : "N",
      "descProyect": value.description
    });

    console.warn(body);

    var requestOptions: RequestInit = {
      method: 'POST',
      headers: myHeaders,
      body: body,
      redirect: 'follow'
    };

    await fetch(environment.api_registro, requestOptions)
      .then(response => response.json())
      .then(result => {
        console.log(result);
        let errors = result.errors;
        let errorRequest = true;
        let errorStr: string = "[";

        errors.forEach((e: { code: string, description: string; }) => {
          if (e.code == "00000") {
            errorRequest = false;
          } else {
            errorStr += e.description + "\n";
          }
        });

        errorStr += "]";

        if (errorRequest) {
          Swal.fire({
            title: 'Error en los datos del formulario!',
            text: 'El formulario presenta los siguientes errores. \n' + errorStr,
            icon: 'error'
          })
        } else {
          Swal.fire({
            title: 'Formulario enviado!',
            text: 'Tus datos se guardaron de manera correcta',
            icon: 'success'
          })
        }
      })
      .catch(error => {
        console.error('error', error)
        Swal.fire({
          title: 'Error!',
          text: 'Sucedio un error al enviar el formulario, por fav or intenta mas tarde',
          icon: 'error'
        })
      });
  }

  // public chnagePhone(event : any): void{
  //   let phone = event.target.value;
  //   let contryCode = this.contactForm.get("country")?.value;
  //   console.log(phone, contryCode);
  // }

  public chnageContryCode(event: any): void {
    let codeCountry = event.target.value;
    console.log(codeCountry);
    if (codeCountry !== "" && this.contactForm.get("country")?.valid) {
      this.contactForm.get("phone")?.enable();
    } else {
      this.contactForm.get("phone")?.disable();
    }

  }

  public chnageDescription(event: any): void {
    let desc = event.target.value;
    this.charCount = 500 - desc.length;
  }

  private async loadOptions(): Promise<void> {

    let requestOptions: RequestInit = {
      method: 'GET',
      redirect: 'follow'
    };


    await fetch(environment.api_contries, requestOptions)
      .then(response => response.json())
      .then(result => {
        result.forEach((element: any) => {
          // console.log(element);
          let value = element.cca2;
          let sufix = element.idd.root + element.idd.suffixes[0];
          let flag = element.flags.svg;
          // console.log(sufix)

          if (sufix !== "undefined")
            this.options.push({ value: value, desc: sufix, flag: flag });
        });
      })
      .catch(error => console.log('error', error));


    // console.warn(this.options);

    this.options.sort(function (a, b) {
      var textA = a.value.toUpperCase();
      var textB = b.value.toUpperCase();
      return (textA < textB) ? -1 : (textA > textB) ? 1 : 0;
    });
  }

  private async numverifyApi(phone: string | null | undefined, country: string | null | undefined) {

    let requestOptions: RequestInit = {
      method: 'GET',
      redirect: 'follow'
    };

    let uri = environment.api_numverify + "?access_key=" + environment.api_key_numverify
      + "&number=" + phone + "&country_code=" + country + "&format=1";

    let numverify = new Numverify();

    await fetch(uri, requestOptions)
      .then(response => response.json())
      .then(result => {
        if (result.success === "false") {
          numverify.error = "true";
          numverify.code = result.code;
          numverify.type = result.type;
          numverify.info = result.info;
        } else {
          numverify.error = "false";
          numverify.valid = result.valid;
          numverify.international_format = result.international_format;
        }
      })
      .catch(error => {
        console.log('error', error);
        numverify.error = "true";
        numverify.code = "";
        numverify.type = "";
        numverify.info = "";
      });


    return numverify;
  }

}
