package com.tambola.validator.impl;

import com.tambola.constants.ApplicationConstants;
import com.tambola.enums.ClaimStatus;
import com.tambola.model.Ticket;
import com.tambola.validator.ClaimValidator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class EarlyFiveValidator implements ClaimValidator {

    @Override
    public ClaimStatus validateClaim(Ticket ticket, List<Integer> announcedNumbers) {
        AtomicBoolean isLastAnnouncedNumberPresent = new AtomicBoolean(false);
        List<Set<Integer>> rows = ticket.getTicketNumbers();
        AtomicInteger countCrossedNumbers = new AtomicInteger();
        announcedNumbers.forEach(number -> {
            AtomicBoolean isPresent = new AtomicBoolean(false);
            rows.forEach(row -> {
                if (row.contains(number) && !isPresent.get())
                    isPresent.set(true);
            });
            if (isPresent.get()) {
                countCrossedNumbers.getAndIncrement();
                isLastAnnouncedNumberPresent.set(true);
            }
            else
                isLastAnnouncedNumberPresent.set(false);
        });
        boolean isValidated = countCrossedNumbers.get() == ApplicationConstants.COLUMN_SIZE && isLastAnnouncedNumberPresent.get();
        return ClaimStatus.isAccepted(isValidated);
    }
}
