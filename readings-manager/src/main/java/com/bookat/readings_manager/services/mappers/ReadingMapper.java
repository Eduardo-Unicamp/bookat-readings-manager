package com.bookat.readings_manager.services.mappers;

import com.bookat.readings_manager.controller.ReadingController;
import com.bookat.readings_manager.entity.Reading;
import com.bookat.readings_manager.repository.BookRepository;
import com.bookat.readings_manager.repository.GroupRepository;
import com.bookat.readings_manager.repository.UserRepository;
import dto.RequestDTO;
import lombok.Data;


public class ReadingMapper {


    public Reading requestDtoToReading(
            RequestDTO requestDTO,
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
        newReading.setBook(bookRepository.findById(requestDTO.getBookId()).orElseThrow());
        newReading.setGroup(groupRepository.findById(requestDTO.getGroupId()).orElseThrow());
        newReading.setUser(userRepository.findById(requestDTO.getUserId()).orElseThrow());

        return newReading;
    }
}
