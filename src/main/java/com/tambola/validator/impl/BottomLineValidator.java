package com.tambola.validator.impl;

import com.tambola.constants.ApplicationConstants;
import com.tambola.enums.ClaimStatus;
import com.tambola.model.Ticket;
import com.tambola.validator.ClaimValidator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class BottomLineValidator implements ClaimValidator {

    @Override
    public ClaimStatus validateClaim(Ticket ticket, List<Integer> announcedNumbers) {
        int lastRow = ApplicationConstants.BOTTOM_ROW;
        int lastAnnouncedNumber = announcedNumbers.get(announcedNumbers.size() - 1);
        Set<Integer> bottomRowSet = ticket.getTicketNumbers().get(lastRow);
        AtomicInteger countCrossedNumbers = new AtomicInteger();
        announcedNumbers.forEach(number -> {
            if (bottomRowSet.contains(number))
                countCrossedNumbers.getAndIncrement();
        });
        boolean isValidated = countCrossedNumbers.get() == ApplicationConstants.COLUMN_SIZE && bottomRowSet.contains(lastAnnouncedNumber);
        return ClaimStatus.getClaimStatusByIsAccepted(isValidated);
    }
}
