package com.example.predmetniProjekatVersion01;

import com.example.predmetniProjekatVersion01.repository.FCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PredmetniProjekatVersion01Application implements CommandLineRunner {

	@Autowired
	private FCRepository fcRepository;

	public static void main(String[] args) {
		SpringApplication.run(PredmetniProjekatVersion01Application.class, args);

		// novi onjekat klase Fitness Centar
		FitnessCentar fitnessCentar = new FitnessCentar();
		fitnessCentar.setNaziv("Pro</G>YM");
		fitnessCentar.setAdresa("Trg Dositeja Obradovica 6");
		fitnessCentar.setBrTelCentrale("0612573450");
		fitnessCentar.setEmail("progym@gmail.com");

		// cuvanje u bazi
		this.fcRepository.save(fitnessCentar)	*/
	}

}
