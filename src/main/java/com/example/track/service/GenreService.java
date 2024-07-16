package com.example.track.service;

import com.example.demo.DTO.GenreDTO;
import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;


    public List<Genre> readAll() {
        return genreRepository.findAll();
    }

    public Genre readById(Long id) {
        return genreRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found - " + id));
    }

    public Genre create(GenreDTO dto){
        Genre category = Genre.builder().title(dto.getTitle()).build();
        return genreRepository.save(category);
    }

    public Genre update(Genre genre){
        return genreRepository.save(genre);
    }

    public void delete(Long id){
        genreRepository.deleteById(id);
    }
}
