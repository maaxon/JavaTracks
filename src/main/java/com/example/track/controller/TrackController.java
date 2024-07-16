package com.example.track.controller;

import com.example.track.DTO.TrackDTO;
import com.example.track.DTO.UpdateTrackDTO;
import com.example.track.entity.Track;
import com.example.track.service.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
@AllArgsConstructor
public class TrackController {
    private final TrackService trackService;

    @GetMapping
    public ResponseEntity<List<Track>> readAll(){
        return mappingResponseListTrack(trackService.readAll());
    }

    @PostMapping
    ResponseEntity<Track> create(@RequestBody TrackDTO dto){
        return mappingResponseTrack(trackService.create(dto));
    }

    @PutMapping
    public ResponseEntity<Track> update(@RequestBody UpdateTrackDTO track) {
        return mappingResponseTrack(trackService.update(track));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        trackService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<List<Track>> readByGenreId(@PathVariable Long id) {
        return mappingResponseListTrack(trackService.readByGenreId(id));
    }

    private ResponseEntity<Track> mappingResponseTrack(Track track) {
        return new ResponseEntity<>(track, HttpStatus.OK);
    }

    private ResponseEntity<List<Track>> mappingResponseListTrack(List<Track> tracks) {
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }
}
