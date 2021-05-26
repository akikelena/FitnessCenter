package com.example.predmetniProjekatVersion01;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.entity.Trener;
import com.example.predmetniProjekatVersion01.repository.*;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;


@SpringBootApplication
public class PredmetniProjekatVersion01Application  {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext=
				SpringApplication.run(PredmetniProjekatVersion01Application.class, args);
		// korisnik
		KorisnikRepository korisnikRepository =
				configurableApplicationContext.getBean(KorisnikRepository.class);
		// clan
		KorisnikRepository clanKorisnikRepository =
				configurableApplicationContext.getBean(ClanRepository.class);

		// administrator
		KorisnikRepository adminKorisnikRepository =
				configurableApplicationContext.getBean(AdministratorRepository.class);

		// trener
		KorisnikRepository trenerKorisnikRepository =
				configurableApplicationContext.getBean(TrenerRepository.class);

		// fitness centar
		FCRepository fcRepository =
				configurableApplicationContext.getBean(FCRepository.class);


	}

}
