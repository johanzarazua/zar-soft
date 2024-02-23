package com.web.zarsoft.dtos;

import com.google.gson.JsonObject;
import com.web.zarsoft.utils.JsonUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter @Setter
public class ResponseDto {
  private Map<String, String> headers;

  private JsonObject body;

  private HttpStatus status;

  @Override
  public String toString() {
    return JsonUtils.objectToJsonStr(this);
  }
}
