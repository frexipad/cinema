package com.frexdel.cinema.model;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class TicketForm implements Serializable {
    private String nomClient;
    private List<Long>listTickets= new ArrayList<>();
}
