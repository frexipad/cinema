package com.frexdel.cinema.model;


import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

//http://localhost:8088/projections/{idProjection}?projection=p1
@Projection(name = "t1",types = {com.frexdel.cinema.model.Ticket.class})
@CrossOrigin("*")
public interface TicketProjection {
    public Long getId();
    public double getPrix();
    public String getNomClient();
    public int getCodePayement();
    public boolean getReserve();
    public Place getPlace();

}
