package com.frexdel.cinema.model;


import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.Collection;

//http://localhost:8088/projections/{idProjection}?projection=p1
@Projection(name = "p1",types = {com.frexdel.cinema.model.Projection.class})
@CrossOrigin("*")
public interface ProjectionProjic {
    public Long getId();
    public double getPrix();
    public LocalDate getDate();
    public Salle getSalle();
    public Film getFilm();
    public Seance getSeance();
    public Collection<Ticket> getTickets();

}
