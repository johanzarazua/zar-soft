package com.web.zarsoft.config;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Security;

@Configuration
public class JasyptEncryptorConfig {

  @Value("${security.default_provider_name}")
  private String SECURITYPROVIDER;

  @Bean(name = "jasyptStringEncryptor")
  public StringEncryptor getPasswordEncryptor() {
    Security.addProvider(new BouncyCastleProvider());

    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
    config.setPassword("Z4rS0ftBK"); // encryptor's private key
    config.setAlgorithm("PBEWithMD5AndDES");
    config.setKeyObtentionIterations("200000");
    config.setPoolSize("1");
    config.setProviderName(SECURITYPROVIDER);
    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    config.setStringOutputType("base64");
    encryptor.setConfig(config);
    return encryptor;
  }
}
