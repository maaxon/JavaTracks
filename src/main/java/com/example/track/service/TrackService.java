package com.example.track.service;

import com.example.demo.DTO.TrackDTO;
import com.example.demo.DTO.UpdateTrackDTO;
import com.example.demo.entity.Track;
import com.example.demo.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;
    private final GenreService genreService;

    public List<Track> readAll() {
        return trackRepository.findAll();
    }

    public Track create(TrackDTO dto){
        Track category = Track.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .duration(dto.getDuration())
                .genre(genreService.readById(dto.getGenre_id()))
                .build();
        return trackRepository.save(category);
    }

    public Track update(UpdateTrackDTO dto){
        Track track = new Track(dto.getId(), dto.getTitle(), dto.getAuthor(), dto.getDuration(),genreService.readById(dto.getGenre_id()));
        return trackRepository.save(track);
    }

    public void delete(Long id){
        trackRepository.deleteById(id);
    }

    public List<Track> readByGenreId(Long id) {
        return trackRepository.findTrackByGenreId(id);
    }
}
