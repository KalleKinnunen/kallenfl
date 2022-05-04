package com.example.kallenfl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kallenfl.domain.Category;
import com.example.kallenfl.domain.CategoryRepository;
import com.example.kallenfl.domain.Pelaaja;
import com.example.kallenfl.domain.PelaajaRepository;
import com.example.kallenfl.domain.User;
import com.example.kallenfl.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class KallenflApplication {
	
	private static final Logger log = LoggerFactory.getLogger(KallenflApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KallenflApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner nfldemo(PelaajaRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of pelaajat");
			crepository.save(new Category("Juostu"));
			crepository.save(new Category("Heitetyt"));
			crepository.save(new Category("Vastaanotetut"));
			crepository.save(new Category(""));
			
			repository.save(new Pelaaja("Tom", "Brady", 4500, crepository.findByName("").get(0)));
			repository.save(new Pelaaja("Derrick", "Henry", 2100, crepository.findByName("").get(0)));	
			
			User user1 = new User("Kalle", "$2a$12$l3xkivl5iQUoyrjDKZtvNuISAY.rpLJNDeM9vPNoUEEPoIqo4gxTi", "USER");
			User user2 = new User("Kalleadmin", "$2a$12$l3xkivl5iQUoyrjDKZtvNuISAY.rpLJNDeM9vPNoUEEPoIqo4gxTi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all pelaajat");
			for (Pelaaja pelaaja : repository.findAll()) {
				log.info(pelaaja.toString());
			}

		};
	}

}
