package com.tambola.validator.impl;

import com.tambola.constants.ApplicationConstants;
import com.tambola.enums.ClaimStatus;
import com.tambola.model.Ticket;
import com.tambola.validator.ClaimValidator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TopLineValidator implements ClaimValidator {

    @Override
    public ClaimStatus validateClaim(Ticket ticket, List<Integer> announcedNumbers) {
        int topRow = ApplicationConstants.TOP_ROW;
        int lastAnnouncedNumber = announcedNumbers.get(announcedNumbers.size() - 1);
        Set<Integer> topRowSet = ticket.getTicketNumbers().get(topRow);
        AtomicInteger countCrossedNumbers = new AtomicInteger();
        announcedNumbers.forEach(number -> {
            if (topRowSet.contains(number))
                countCrossedNumbers.getAndIncrement();
        });
        boolean isValidated = countCrossedNumbers.get() == ApplicationConstants.COLUMN_SIZE && topRowSet.contains(lastAnnouncedNumber);
        return ClaimStatus.getClaimStatusByIsAccepted(isValidated);
    }

}
