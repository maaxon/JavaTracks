package com.example.track.DTO;

import lombok.Data;

@Data
public class TrackDTO {
    private String title;
    private String author;
    private Integer duration;
    private Long genre_id;
}
