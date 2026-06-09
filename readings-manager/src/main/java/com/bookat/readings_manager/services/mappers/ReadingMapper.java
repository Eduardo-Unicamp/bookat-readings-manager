package com.bookat.readings_manager.services.mappers;

import com.bookat.readings_manager.entity.Reading;
import com.bookat.readings_manager.exception.BookNotFoundException;
import com.bookat.readings_manager.exception.GroupNotFoundException;
import com.bookat.readings_manager.exception.UserNotFoundException;
import com.bookat.readings_manager.infra.security.UserDetailsImpl;
import com.bookat.readings_manager.repository.BookRepository;
import com.bookat.readings_manager.repository.GroupRepository;
import com.bookat.readings_manager.repository.UserRepository;
import com.bookat.readings_manager.dto.RequestDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


public class ReadingMapper {


    public Reading requestDtoToReading(
            RequestDTO requestDTO,
            UserDetailsImpl loggedUser,
            UserRepository userRepository,
            BookRepository bookRepository,
            GroupRepository groupRepository
    )
    {
        Reading newReading = new Reading();
//lembrar de adicionar exceções personalizadas nos throws
        newReading.setCurrentPage(requestDTO.getCurrentPage());
        newReading.setReadingStatus(requestDTO.getReadingStatus());
        newReading.setReadingStartDate(requestDTO.getReadingStartDate());
        newReading.setReadingFinishDate(requestDTO.getReadingFinishDate());
        newReading.setFeedback(requestDTO.getFeedback());
        newReading.setBook(bookRepository.findById(requestDTO.getBookId()).orElseThrow(BookNotFoundException::new));
        newReading.setGroup(groupRepository.findById(requestDTO.getGroupId()).orElseThrow(GroupNotFoundException::new));
       newReading.setUser(userRepository.findById(loggedUser.getUser().getUserId()).orElseThrow(UserNotFoundException::new));

        return newReading;
    }
}
