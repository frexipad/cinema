package com.frexdel.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private double prix;

    @ManyToOne
    private Salle salle;

    @ManyToOne
    private Film film;

    @OneToMany(mappedBy = "projection")
    Collection<Ticket> tickets;

    @ManyToOne
    Seance seance;
}
