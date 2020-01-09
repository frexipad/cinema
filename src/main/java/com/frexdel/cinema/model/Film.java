package com.frexdel.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Film implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "filmId_generator")
//    @SequenceGenerator(name = "filmId_generator",initialValue = 1,allocationSize = 1,sequenceName = "filmid_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "filmId_generator")
    private Long id;
    @Column(length = 150)
    private String title;
    private double duree;
    @Column(length = 75)
    private String realisateur;
    private String discription;
    private String photo;
    private LocalTime time;

    @ManyToMany(mappedBy = "films")
    private Collection<Salle> salles ;

    @OneToMany(mappedBy = "film")
    private Collection<Projection> projections ;

    @ManyToOne
    private Categorie categorie;

    public Film(String title) {
        this.title = title;
    }
}
