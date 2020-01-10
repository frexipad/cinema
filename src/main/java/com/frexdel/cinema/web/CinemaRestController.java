package com.frexdel.cinema.web;

import com.frexdel.cinema.dao.FilmRepository;
import com.frexdel.cinema.model.Film;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@RestController
public class CinemaRestController {
    private FilmRepository filmRepository;

    public CinemaRestController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping(path = "/image",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte [] getImageFilm(@RequestParam Long idFilm) throws IOException {
        Film film= filmRepository.findById(idFilm).get();
        Long fId = film.getId();
        File file= new File(System.getProperty("user.home")+"/Pictures/imagesFilm/"+fId+".jpg");
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);

    }
}
