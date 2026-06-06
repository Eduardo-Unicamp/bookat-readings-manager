package com.bookat.readings_manager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name = "genres")
public class Genre{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id")
    private UUID genreId;
    @Column(name = "genreName", nullable = false)
    private String genreName;

}
