package com.frexdel.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private double longitude,latitude,altitude;

    @ManyToOne
    private Salle salle;


    @OneToMany(mappedBy = "place",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    Collection<Ticket> tickets;


}
