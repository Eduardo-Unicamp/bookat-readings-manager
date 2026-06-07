package com.bookat.readings_manager.services;

import com.bookat.readings_manager.entity.Reading;
import com.bookat.readings_manager.exception.ReadingNotFoundException;
import com.bookat.readings_manager.infra.security.UserDetailsImpl;
import com.bookat.readings_manager.repository.BookRepository;
import com.bookat.readings_manager.repository.GroupRepository;
import com.bookat.readings_manager.repository.ReadingRepository;
import com.bookat.readings_manager.repository.UserRepository;
import com.bookat.readings_manager.services.mappers.ReadingMapper;
import com.bookat.readings_manager.dto.RequestDTO;
import com.bookat.readings_manager.dto.ResponseDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReadingService {
    private final ReadingRepository readingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final GroupRepository groupRepository;
    private ReadingMapper readingMapper;
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
        return new ResponseDTO(readingRepository.findByUserUserId(userId));
    }

    public void addReading(RequestDTO requestDTO,UserDetailsImpl loggedUser){
        ReadingMapper mapper = new ReadingMapper();
        Reading newReading = mapper.requestDtoToReading(
                requestDTO,
                loggedUser,
                userRepository,
                bookRepository,
                groupRepository
        );
        readingRepository.save(newReading);
    }

    public void deleteReading(UUID readingId){
        readingRepository.deleteById(readingId);
    }

    public void updateReading(UUID readingId, RequestDTO requestDTO,UserDetailsImpl loggedUser){
        //ensures that reading already exists
        if(readingRepository.findById(readingId).isEmpty())
            throw new ReadingNotFoundException();

        ReadingMapper mapper = new ReadingMapper();
        Reading newReading = mapper.requestDtoToReading(
                requestDTO,
                loggedUser,
                userRepository,
                bookRepository,
                groupRepository
        );
        newReading.setReadingId(readingId);
        readingRepository.save(newReading);
    }
}
