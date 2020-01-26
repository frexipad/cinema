package com.frexdel.cinema.service;

import com.frexdel.cinema.dao.*;
import com.frexdel.cinema.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
@Service
@Transactional
public class ICinemaInitServiceImpl implements ICinemaInitService {
    @Autowired
    VilleRepository villeRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    ProjectionRepository projectionRepository;
    @Autowired
    SeanceRepository seanceRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    FilmRepository filmRepository;

    @Override
    public void initVilles() {
        Stream.of("Bruxelles","Anvers","Bruge","Ostande","Mechelen").forEach(
                nameVille->{
                    Ville ville =new Ville();
                    ville.setName(nameVille);
                    villeRepository.save(ville);
                }
        );
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(ville -> {
            Stream.of("Kinepolis","UGC","MegaRama","IMAX","FOUNOUN").forEach(nameCinema->{
                Cinema cinema=new Cinema();
                cinema.setName(nameCinema);
                cinema.setVille(ville);
                cinemaRepository.save(cinema);
            });
        });
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(cinema -> {
            Stream.of("Salle 1","Salle 2","Salle 3","Salle 4","Salle 5","Salle 6","Salle 7").forEach(nameSalle->{
                Salle salle = new Salle();
                salle.setName(nameSalle);
                salle.setCinema(cinema);
                salle.setNombrePlace(15+(int) Math.random()*20);
                salleRepository.save(salle);
            });
        });
    }

    @Override
    public void initPlaces() {
        AtomicInteger counter = new AtomicInteger(1);
        salleRepository.findAll().forEach(salle -> {
            for (int i = 0; i < salle.getNombrePlace(); i++) {
                Place place =new Place();
                place.setSalle(salle);
                place.setNumero(counter.getAndAdd(1));
                placeRepository.save(place);
            }
                });
    }

    @Override
    public void initSeances() {
        Stream.of(LocalTime.of(12,00,00),LocalTime.of(13,30,00),LocalTime.of(16,00,00),LocalTime.of(17,00,00),LocalTime.of(20,00,00),LocalTime.of(22,00,00),LocalTime.of(22,15,00)).forEach(heureDebutSeance->{
            Seance seance=new Seance();
            seance.setHeureDebut(heureDebutSeance);
            seanceRepository.save(seance);

        });
    }

    @Override
    public void initCategories() {
        Stream.of("series","mongua","3d","kids","police").forEach(s -> {
            Categorie categorie = new Categorie();
            categorie.setName(s);
            categorieRepository.save(categorie);
        });

    }

    @Override
    public void initFilms() {
        Stream.of("1","2","3").forEach(filmName->{
            List<Categorie> categorieList = categorieRepository.findAll();
            Film film = new Film();
            film.setTitle(filmName);
            film.setDiscription("Description unkhnoun");
            film.setCategorie(categorieList.get(new Random().nextInt(categorieList.size())));
            filmRepository.save(film);
        });

    }

    @Override
    public void initProjections() {
        double [] prix ={30,60,80,90,120,160};
        List<Film> filmList= filmRepository.findAll();
                salleRepository.findAll().forEach(salle -> {
                    int index = new Random().nextInt(filmList.size());
                    seanceRepository.findAll().forEach(seance -> {
                        Film film = filmList.get(index);
                            Projection projection = new Projection();
                            projection.setDate(LocalDateTime.now());
                            projection.setFilm(film);
                            projection.setSalle(salle);
                            projection.setPrix(80);
                            projection.setSeance(seance);
                            projectionRepository.save(projection);
                        });

                    });
    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(projection -> {
            projection.getSalle().getPlaces().forEach(place -> {
                Ticket ticket= new Ticket();
                ticket.setReserve(false);
                ticket.setPlace(place);
                ticket.setProjection(projection);
                ticket.setPrix(90);
                ticketRepository.save(ticket);
            });
        });
    }
}
