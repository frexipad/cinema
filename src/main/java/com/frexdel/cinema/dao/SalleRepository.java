package com.frexdel.cinema.dao;

import com.frexdel.cinema.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Long> {
}
