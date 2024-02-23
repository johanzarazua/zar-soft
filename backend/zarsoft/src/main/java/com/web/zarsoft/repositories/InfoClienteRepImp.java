package com.web.zarsoft.repositories;

import com.web.zarsoft.entities.InfoCliente;
import oracle.sql.TIMESTAMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Component
public class InfoClienteRepImp {
  @Autowired
  InfoClienteRep infoClienteRep;

  public List<InfoCliente> findAll(){
    return infoClienteRep.findAll();
  }

//  public Timestamp sysdate(){
//    List<Object[]> resulset = infoClienteRep.date();
//    System.out.println(resulset);
//    return (Timestamp) resulset.get(0)[0];
//  }

  public InfoCliente save(InfoCliente infoCliente) throws JpaSystemException {
    return infoClienteRep.save(infoCliente);
  }

}
