package com.bookat.readings_manager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@Table(name = "books")
public class Book{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "book_id")
    private UUID bookId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private Integer edition;

    @Column(nullable = false)
    private String overview;

    private String isbn;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @ManyToMany
    @JoinTable(
            name = "book_genres",
            joinColumns =@JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id")
    )
    private List<Genre> genreTags = new ArrayList<>();
}
