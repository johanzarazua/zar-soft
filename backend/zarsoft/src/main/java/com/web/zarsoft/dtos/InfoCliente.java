package com.web.zarsoft.dtos;

import com.web.zarsoft.utils.JsonUtils;
import com.web.zarsoft.utils.Utils;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoCliente {
  @NotEmpty(message = "El nombre es requerido")
  @Pattern(regexp = "[A-Za-z\\s]+", message = "El nombre no tiene un formato correcto")
  @Length(max = 100, message = "El nombre debe contener maximo 100 carcateres")
  private String nombre;

  @NotEmpty(message = "El email es requerido")
  @Email(message = "El email no tiene un formato correcto")
  @Length(max = 500, message = "El email debe contener maximo 500 carcateres")
  private String email;

  @NotEmpty(message = "El telefono es requerido")
  @Pattern(regexp = "[0-9]{10}", message = "El telefono no tinene un formato correcto, numero a 10 digitos")
  private String phone;

  @NotEmpty(message = "La verificacion del telefono es requerida")
  @Pattern(regexp = "[VN]{1}", message = "La verificacion no tiene un formato correcto")
  private String phoneVerify;

  @NotEmpty(message = "La descripcion del proyecto es requerida")
  @Length(max = 500, message = "La descripcion debe contener maximo 500 carcateres")
  private String descProyect;

  @Override
  public String toString() {
    return JsonUtils.objectToJsonStr(this);
//    return "{" +
//            "nombre:'" + nombre + '\'' +
//            ", email:'" + email + '\'' +
//            ", phone:'" + phone + '\'' +
//            ", phoneVerify:" + phoneVerify +
//            ", descProyect:'" + descProyect + '\'' +
//            '}';
  }
}
