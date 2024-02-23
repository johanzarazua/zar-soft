package com.web.zarsoft.services;

import com.google.gson.JsonObject;
import com.web.zarsoft.dtos.ErrorDto;
import com.web.zarsoft.dtos.ResponseDto;
import com.web.zarsoft.entities.InfoCliente;
import com.web.zarsoft.repositories.InfoClienteRepImp;
import com.web.zarsoft.utils.ExceptionUtils;
import com.web.zarsoft.utils.JsonUtils;
import com.web.zarsoft.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;

@Service
public class InfoClienteService {

  @Value("${spring.datasource.username}")
  private String DBUSERNAME;

  Logger logger = LoggerFactory.getLogger(InfoClienteService.class);

  @Autowired
  private InfoClienteRepImp infoClienteRepImp;

  public Map<String, String> listAll(){
    Map<String, String> body = new HashMap<>();
    List<InfoCliente> clientes = infoClienteRepImp.findAll();
    System.out.println(clientes);
    body.put("clientes", clientes.toString());
//    body.put("fecha", String.valueOf(infoClienteRepImp.sysdate()));
    return body;
  }

  @Transactional
  public void create(com.web.zarsoft.dtos.InfoCliente infoCliente, ResponseDto response)  {
    logger.info("Iniciando servicio crear");
//    ResponseDto response = new ResponseDto();

    Map<String, Object> body =  new HashMap<>();
    List<ErrorDto> errors = new ArrayList<>();

    logger.info("Request recibido: {}", infoCliente.toString());
    InfoCliente infoClienteentity = new InfoCliente(infoCliente);
    infoClienteentity.setDateCreate(Utils.getFechaSys());

    try{
      infoClienteentity = infoClienteRepImp.save(infoClienteentity);
      logger.info("Info almacenada: {}", infoClienteentity.toString());


      if (infoClienteentity.getInfoClienteId() == null || infoClienteentity.getInfoClienteId() == 0){
        errors.add(new ErrorDto("00001", "No se puedo almacenar la infromacion"));
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
      }else{
        errors.add(new ErrorDto("00000", ""));
        body.put("cliente", infoClienteentity);
        response.setStatus(HttpStatus.OK);
      }


    }catch (JpaSystemException exception){
      logger.error(exception.getMostSpecificCause().getMessage());
      String msg = ExceptionUtils.JpaSystemExceptionMsg(exception.getMostSpecificCause().getMessage());
      String code = ExceptionUtils.JpaSystemExceptionCode(exception.getMostSpecificCause().getMessage());
      errors.add(new ErrorDto(code, msg));
      response.setStatus(HttpStatus.BAD_REQUEST);
      logger.error("JpaError: [{}] {}",code, msg);
    }

    body.put("errors", errors);
    JsonObject responseJson = JsonUtils.jsonStrToJsonObject(JsonUtils.mapToJsonStr(body));
    logger.info("response enviado: {}", responseJson);
    response.setBody(responseJson);

    logger.info("Finalizando servicio crear");

//    return response;
  }
}
