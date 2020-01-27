package com.springdata.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springdata.demo.pojo.Usuario;
import com.springdata.demo.pojo.UsuarioRepository;

@SpringBootApplication
public class SpringDataDemo2Application {

	private static final Logger log = LoggerFactory.getLogger(SpringDataDemo2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemo2Application.class, args);
	}
	
	  @Bean
	  public CommandLineRunner demo(UsuarioRepository repository) {
	    return (args) -> {
	      // save a few customers
	      repository.save(new Usuario("1", "Bauer","111111"));
	      repository.save(new Usuario("1", "Alejo", "666666"));
	      repository.save(new Usuario("1", "Santi", "22222"));
	      Usuario david = new Usuario("2", "David", "4567");
	      repository.save(david);
	      repository.save(new Usuario("3", "Michelle", "44444"));

	      // fetch all customers
	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      for (Usuario usuario : repository.findAll()) {
	        log.info(usuario.toString());
	      }
	      log.info("");
	      // fetch all customers deleting one
	      repository.delete(david);
	      log.info("Customers found with findAll() after delete:");
	      log.info("-------------------------------");
	      for (Usuario usuario : repository.findAll()) {
	        log.info(usuario.toString());
	      }
	      log.info("");

	      // fetch an individual customer by ID
	      Usuario usuario = repository.findById(10L);
	      log.info("Customer found with findById(10L):");
	      log.info("--------------------------------");
	      log.info(usuario.toString());
	      log.info("");
	      
	      usuario.setIdentificacion("999199999");
	      repository.save(usuario);
	      usuario = repository.findById(10L);
	      log.info("Customer found with findById(10L), after update:");
	      log.info("--------------------------------");
	      log.info(usuario.toString());
	      log.info("");	      

	      // fetch customers by last name
	      log.info("Customer found with findByNombre('Bauer'):");
	      log.info("--------------------------------------------");
	      repository.findByNombre("Bauer").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	      // for (Customer bauer : repository.findByLastName("Bauer")) {
	      //  log.info(bauer.toString());
	      // }
	      log.info("");
	    };
	  }

}
