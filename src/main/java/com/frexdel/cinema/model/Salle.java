package com.frexdel.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String name;
    private int nombrePlace;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "salle")
    private Collection<Place> places;

    @ManyToMany()
    @JoinTable(name = "film_salle",
            joinColumns = @JoinColumn(name = "salle_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> films;

    @OneToMany(mappedBy = "salle")
    Collection<Projection> projections;
}
