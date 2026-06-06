package dto;

import com.bookat.readings_manager.entity.Book;
import com.bookat.readings_manager.entity.Group;
import com.bookat.readings_manager.entity.User;
import com.bookat.readings_manager.enums.ReadingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
public class RequestDTO {

    private Integer currentPage;

    private ReadingStatus readingStatus;

    private LocalDate readingStartDate;

    private LocalDate readingFinishDate;

    private String feedback;

    private UUID userId;

    private UUID groupId;

    private UUID bookId;
}
