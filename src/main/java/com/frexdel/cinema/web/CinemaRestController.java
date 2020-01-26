package com.frexdel.cinema.web;

import com.frexdel.cinema.dao.FilmRepository;
import com.frexdel.cinema.dao.TicketRepository;
import com.frexdel.cinema.model.Film;
import com.frexdel.cinema.model.Ticket;
import com.frexdel.cinema.model.TicketForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
public class CinemaRestController {
    private FilmRepository filmRepository;
    private TicketRepository ticketRepository;

    public CinemaRestController(FilmRepository filmRepository, TicketRepository ticketRepository) {
        this.filmRepository = filmRepository;
        this.ticketRepository = ticketRepository;
    }

    @GetMapping(path = "/image",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte [] getImageFilm(@RequestParam Long idFilm) throws IOException {
        Film film= filmRepository.findById(idFilm).get();
        Long fId = film.getId();
        File file= new File(System.getProperty("user.home")+"/Pictures/images/"+fId+".jpg");
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);

    }

    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> ticketListAchete(@RequestBody TicketForm ticketForm){

        List<Ticket> ticketList = new ArrayList<>();
        ticketForm.getListTickets().forEach(idTicketPayer->{
            Ticket ticket = ticketRepository.findById(idTicketPayer).get();
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setCodePayement(ticketForm.getCodePayement());
            ticket.setReserve(true);
            ticketList.add(ticket);
            ticketRepository.save(ticket);
        });
        return ticketList;
    }
}
