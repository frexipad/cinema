package com.frexdel.cinema;

import com.frexdel.cinema.dao.FilmRepository;
import com.frexdel.cinema.model.Film;
import com.frexdel.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {
    @Autowired
    ICinemaInitService iCinemaInitService;
    @Autowired
    FilmRepository filmRepository;

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        iCinemaInitService.initVilles();
        iCinemaInitService.initCinemas();
        iCinemaInitService.initSalles();
        iCinemaInitService.initPlaces();
        iCinemaInitService.initSeances();
        iCinemaInitService.initCategories();
        iCinemaInitService.initFilms();
        iCinemaInitService.initProjections();
        iCinemaInitService.initTickets();
        System.out.println(filmRepository.save(new Film("ynss")));
        System.out.println("---------------------------------------------------");

    }
}
