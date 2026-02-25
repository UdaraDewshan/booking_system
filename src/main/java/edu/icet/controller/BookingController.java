package edu.icet.controller;

import edu.icet.model.dto.BookingDTO;
import edu.icet.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<BookingDTO> bookSlot(@RequestBody BookingDTO request){
        BookingDTO response = bookingService.bookSlot(request);
        return ResponseEntity.ok(response);
    }

}
