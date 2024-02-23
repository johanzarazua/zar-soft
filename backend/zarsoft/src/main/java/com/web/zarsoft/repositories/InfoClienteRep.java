package com.web.zarsoft.repositories;

import com.web.zarsoft.entities.InfoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InfoClienteRep extends JpaRepository<InfoCliente, Long> {
//  @Query(value = "select sysdate from dual", nativeQuery = true)
//  List<Object[]> date();
}
