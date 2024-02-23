package com.web.zarsoft.entities;


import com.web.zarsoft.utils.JsonUtils;
import com.web.zarsoft.utils.Utils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "info_cliente")
@Getter @Setter
public class InfoCliente {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "info_cliente_id")
  private Long infoClienteId;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "email")
  private String email;

  @Column(name = "email_verify")
  private char emailVerify;

  @Column(name = "phone")
  private String phone;

  @Column(name = "phone_verify")
  private String phoneVerify;

  @Column(name = "desc_proyect")
  private String descProyect;

  @Column(name = "date_create")
  private Timestamp dateCreate;

  public InfoCliente() {

  }

  public InfoCliente(String nombre, String email, char emailVerify, String phone, String phoneVerify, String descProyect, Timestamp dateCreate) {
    this.nombre = nombre;
    this.email = email;
    this.emailVerify = emailVerify;
    this.phone = phone;
    this.phoneVerify = phoneVerify;
    this.descProyect = descProyect;
    this.dateCreate = dateCreate;
  }

  public InfoCliente(com.web.zarsoft.dtos.InfoCliente infoCliente) {
    this.nombre = infoCliente.getNombre();
    this.email = infoCliente.getEmail();
    this.emailVerify = '0';
    this.phone = infoCliente.getPhone();
    this.phoneVerify = infoCliente.getPhoneVerify();
    this.descProyect = infoCliente.getDescProyect();
  }

  @Override
  public String toString() {
    return JsonUtils.objectToJsonStr(this);
//    return "{" +
//            " 'infoClienteId':" + infoClienteId +
//            ", 'nombre':'" + nombre + '\'' +
//            ", 'email':'" + email + '\'' +
//            ", 'emailVerify':" + emailVerify +
//            ", 'phone':'" + phone + '\'' +
//            ", 'phoneVerify':" + phoneVerify +
//            ", 'descProyect':'" + descProyect + '\'' +
//            ", 'dateCreate':'" + dateCreate + '\'' +
//            '}';
  }
}
