package com.bookat.readings_manager.controller;
import com.bookat.readings_manager.infra.security.UserDetailsImpl;
import com.bookat.readings_manager.services.ReadingService;
import com.bookat.readings_manager.dto.RequestDTO;
import com.bookat.readings_manager.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/readings-manager")
public class ReadingController {
    private final ReadingService readingService;

    public ReadingController(ReadingService readingService){
        this.readingService = readingService;
    }

    @GetMapping()//get all tasks
    public ResponseEntity<ResponseDTO> getReadings(@AuthenticationPrincipal UserDetailsImpl loggedUser){
        ResponseDTO response = readingService.getReadings(loggedUser);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<Void> postTask(@RequestBody RequestDTO requestDTO,@AuthenticationPrincipal UserDetailsImpl loggedUser){
        readingService.addReading(requestDTO,loggedUser);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{readingId}")
    public ResponseEntity<Void> deleteReading(@PathVariable UUID readingId){
        readingService.deleteReading(readingId);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/{readingId}")
    public ResponseEntity<Void> updateReadings(
            @PathVariable UUID readingId,
            @RequestBody RequestDTO requestDTO,
            @AuthenticationPrincipal UserDetailsImpl loggedUser
    )
    {
        readingService.updateReading(readingId,requestDTO,loggedUser);
        return ResponseEntity.ok().build();
    }

}
