package com.frexdel.cinema;

import com.frexdel.cinema.dao.FilmRepository;
import com.frexdel.cinema.model.Film;
import com.frexdel.cinema.model.Projection;
import com.frexdel.cinema.model.Salle;
import com.frexdel.cinema.model.Ticket;
import com.frexdel.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {
    @Autowired
    ICinemaInitService iCinemaInitService;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Film.class, Projection.class,Salle.class,Ticket.class);

//        iCinemaInitService.initVilles();
//        iCinemaInitService.initCinemas();
//        iCinemaInitService.initSalles();
//        iCinemaInitService.initPlaces();
//        iCinemaInitService.initCategories();
//        iCinemaInitService.initFilms();
//        iCinemaInitService.initSeances();
//        iCinemaInitService.initProjections();
//        iCinemaInitService.initTickets();
        System.out.println(filmRepository.save(new Film("ynss")));
        System.out.println("---------------------------------------------------");

    }
}
