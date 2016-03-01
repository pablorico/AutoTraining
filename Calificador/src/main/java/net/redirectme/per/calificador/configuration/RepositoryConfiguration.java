package net.redirectme.per.calificador.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"net.redirectme.per.calificador.entities"})
@EnableJpaRepositories(basePackages = {"net.redirectme.per.calificador.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}