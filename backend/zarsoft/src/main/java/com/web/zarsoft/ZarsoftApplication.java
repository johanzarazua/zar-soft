package com.web.zarsoft;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.web.zarsoft.repositories.InfoClienteRep;
import com.web.zarsoft.repositories.InfoClienteRepImp;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.security.Security;
import java.security.Provider;

@SpringBootApplication
@EnableEncryptableProperties
@EnableTransactionManagement
public class ZarsoftApplication {


	public static void main(String[] args) {
		SpringApplication.run(ZarsoftApplication.class, args);
//		Provider[] providers = Security.getProviders();
//		for (int i = 0; i < providers.length; i++) {
//			Provider provider =  providers[i];
//			System.out.println(provider.getName());
//		}

	}

}
