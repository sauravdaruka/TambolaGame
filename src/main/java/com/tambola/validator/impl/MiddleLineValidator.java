package com.tambola.validator.impl;

import com.tambola.constants.ApplicationConstants;
import com.tambola.enums.ClaimStatus;
import com.tambola.model.Ticket;
import com.tambola.validator.ClaimValidator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MiddleLineValidator implements ClaimValidator {
    @Override
    public ClaimStatus validateClaim(Ticket ticket, List<Integer> announcedNumbers) {
        int middleRow = ApplicationConstants.MIDDLE_ROW;
        int lastAnnouncedNumber = announcedNumbers.get(announcedNumbers.size() - 1);
        Set<Integer> middleRowSet = ticket.getTicketNumbers().get(middleRow);
        AtomicInteger countCrossedNumbers = new AtomicInteger();
        announcedNumbers.forEach(number -> {
            if (middleRowSet.contains(number))
                countCrossedNumbers.getAndIncrement();
        });
        boolean isValidated = countCrossedNumbers.get() == ApplicationConstants.COLUMN_SIZE && middleRowSet.contains(lastAnnouncedNumber);
        return ClaimStatus.getClaimStatusByIsAccepted(isValidated);
    }
}
