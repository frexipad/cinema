package com.frexdel.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomClient;
    private double prix;
    private int codePayement;
    private boolean reserve ;
    @ManyToOne
    @JsonBackReference
    private Place place;
    @ManyToOne
    private Projection projection;

}
