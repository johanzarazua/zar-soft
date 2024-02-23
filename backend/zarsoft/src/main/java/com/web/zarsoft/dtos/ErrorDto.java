package com.web.zarsoft.dtos;

import com.web.zarsoft.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

  private String code;
  private String description;

  @Override
  public String toString() {
    return JsonUtils.objectToJsonStr(this);
  }
}
