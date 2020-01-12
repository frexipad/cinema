package com.frexdel.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Seance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime heureDebut;


}
