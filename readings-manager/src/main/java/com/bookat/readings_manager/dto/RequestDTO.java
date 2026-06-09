package com.bookat.readings_manager.dto;

import com.bookat.readings_manager.entity.Book;
import com.bookat.readings_manager.entity.Group;
import com.bookat.readings_manager.entity.User;
import com.bookat.readings_manager.enums.ReadingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
public class RequestDTO {

    private Integer currentPage;
    @NotNull
    private ReadingStatus readingStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate readingStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate readingFinishDate;

    private String feedback;

    @NotNull
    private UUID groupId;
    @NotNull
    private UUID bookId;
}
