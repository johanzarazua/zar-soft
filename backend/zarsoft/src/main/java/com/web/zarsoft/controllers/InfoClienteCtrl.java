package com.web.zarsoft.controllers;

import com.web.zarsoft.dtos.InfoCliente;
import com.web.zarsoft.dtos.ResponseDto;
import com.web.zarsoft.repositories.InfoClienteRepImp;
import com.web.zarsoft.services.InfoClienteService;
import com.web.zarsoft.utils.JsonUtils;
import com.web.zarsoft.utils.Utils;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
@CrossOrigin
public class InfoClienteCtrl {

  Logger logger = LoggerFactory.getLogger(InfoClienteCtrl.class);

  @Autowired
  InfoClienteService infoClienteService;

  @GetMapping(value = "/clientes/list")
  public ResponseEntity<?> listAll(){
    Map<String, String> body = infoClienteService.listAll();
    return new ResponseEntity<>(body, HttpStatus.OK);
  }

  @PostMapping(value = "/cliente/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> createCliente(@Valid @RequestBody InfoCliente infoCliente) {
    logger.info("Inicando controller crear");
    ResponseDto response = new ResponseDto();
    try{
      infoClienteService.create(infoCliente, response);
    }catch (UnexpectedRollbackException exception){
      logger.error(exception.getMessage());
      logger.debug(response.toString());
    }

    logger.info("Finalizando controller crear");
    return new ResponseEntity<>(JsonUtils.objectToJsonStr(response.getBody()), response.getStatus());
  }
}
