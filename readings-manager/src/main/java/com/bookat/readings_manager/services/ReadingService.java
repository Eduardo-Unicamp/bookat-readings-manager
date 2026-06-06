package com.bookat.readings_manager.services;

import com.bookat.readings_manager.entity.Reading;
import com.bookat.readings_manager.repository.BookRepository;
import com.bookat.readings_manager.repository.GroupRepository;
import com.bookat.readings_manager.repository.ReadingRepository;
import com.bookat.readings_manager.repository.UserRepository;
import com.bookat.readings_manager.services.mappers.ReadingMapper;
import dto.RequestDTO;
import dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReadingService {
    private final ReadingRepository readingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final GroupRepository groupRepository;
    //constructor
    public ReadingService(
            ReadingRepository readingRepository,
            UserRepository userRepository,
            BookRepository bookRepository,
            GroupRepository groupRepository
            )
    {
        this.readingRepository=readingRepository;
        this.userRepository=userRepository;
        this.bookRepository=bookRepository;
        this.groupRepository=groupRepository;

    }


    public ResponseDTO getReadings(UserDetailsImpl loggedUser){
        UUID userId = loggedUser.getUser().getUserId();
        return new ResponseDTO(readingRepository.findByUserId(userId));
    }

    public void addReadings(RequestDTO requestDTO){
        ReadingMapper mapper = new ReadingMapper();
        Reading newReading = mapper.requestDtoToReading(
                requestDTO,
                userRepository,
                bookRepository,
                groupRepository
        );
        readingRepository.save(newReading);
    }
}
