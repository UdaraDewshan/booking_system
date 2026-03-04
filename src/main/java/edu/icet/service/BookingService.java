package edu.icet.service;

import edu.icet.model.dto.BookingDTO;

public interface BookingService {
    BookingDTO bookSlot(BookingDTO request);
}
