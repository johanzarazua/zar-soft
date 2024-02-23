package com.web.zarsoft.exceptions;

import com.web.zarsoft.dtos.ErrorDto;
import com.web.zarsoft.dtos.ResponseDto;
import com.web.zarsoft.utils.Utils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class RequestExceptionHandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    Map<String, Object> body = new HashMap<>();

    List<ErrorDto> errorsDtos = new ArrayList<>();
    ex.getBindingResult()
      .getFieldErrors()
      .stream()
      .forEach(exMsg -> {
        errorsDtos.add(new ErrorDto("00001", exMsg.getDefaultMessage()));
      });


    body.put("errors", errorsDtos);
    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
}
