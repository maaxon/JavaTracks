package com.example.track.controller;

import com.example.track.DTO.GenreDTO;
import com.example.track.entity.Genre;
import com.example.track.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<List<Genre>> readAll(){
        return mappingResponseListGenre(genreService.readAll());
    }

    @PostMapping
    ResponseEntity<Genre> create(@RequestBody GenreDTO dto){
        return mappingResponseGenre(genreService.create(dto));
    }

    @PutMapping
    public ResponseEntity<Genre> update(@RequestBody Genre genre) {
        return mappingResponseGenre(genreService.update(genre));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        genreService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> readById(@PathVariable Long id) {
        return mappingResponseGenre(genreService.readById(id));
    }

    private ResponseEntity<Genre> mappingResponseGenre(Genre genre) {
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    private ResponseEntity<List<Genre>> mappingResponseListGenre(List<Genre> genres) {
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
}
