package com.example.track.repository;

import com.example.track.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track,Long> {
    List<Track> findTrackByGenreId(Long id);
}
