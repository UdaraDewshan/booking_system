package edu.icet.service;

import edu.icet.model.dto.InterviewSlotDTO;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface InterviewSlotService {
    void addSlot(InterviewSlotDTO request);

    List<InterviewSlotDTO> getAvailbleSlots();
}
