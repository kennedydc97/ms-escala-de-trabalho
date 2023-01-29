package com.eldorado.microservico.escaladetrabalho;

import com.eldorado.commons.configuration.EnableMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableRabbit
@EnableMapper
public class MsEscalaDeTrabalhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEscalaDeTrabalhoApplication.class, args);
	}

}
