package edu.icet.service;

import edu.icet.model.dto.InterviewSlotDTO;
import java.util.List;

public interface InterviewSlotService {
    void addSlot(InterviewSlotDTO request);
    List<InterviewSlotDTO> getAvailbleSlots();

    List<InterviewSlotDTO> getBookedSlots();
}
