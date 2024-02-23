package com.web.zarsoft.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

  @Value("${spring.datasource.username}")
  private String DBUSERNAME;

  @Value("${spring.datasource.password}")
  private String DBPWD;

  @Value("${db.url}")
  private String DBURL;

  @Value("${wallet.dir}")
  private String WALLETDIR;


  @Bean
  public DataSource dataSource(){

    System.setProperty("oracle.net.tns_admin", WALLETDIR + "/" + "wallet");

    String urlDB = DBURL;
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
    hikariConfig.setJdbcUrl(urlDB);
    hikariConfig.setUsername(DBUSERNAME);
    hikariConfig.setPassword(DBPWD);

    hikariConfig.setConnectionTestQuery("select sysdate from dual");
    hikariConfig.setMaximumPoolSize(3);
    hikariConfig.setMinimumIdle(1);

    return new HikariDataSource(hikariConfig);
  }

}
