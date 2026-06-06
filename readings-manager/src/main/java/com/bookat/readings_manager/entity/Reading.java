package com.bookat.readings_manager.entity;

import com.bookat.readings_manager.enums.ReadingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
@Entity
@Table(name = "readings")
public class Reading{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reading_id")
    private UUID readingId;

    @Column(name = "current_page")
    private Integer currentPage;

    @Column(name = "reading_status")
    @Enumerated(EnumType.STRING)
    private ReadingStatus readingStatus;

    @Column(name = "reading_start_date")
    private LocalDate readingStartDate;

    @Column(name = "reading_finish_date")
    private LocalDate readingFinishDate;
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
