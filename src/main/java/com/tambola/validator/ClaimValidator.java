package com.tambola.validator;


import com.tambola.enums.ClaimStatus;
import com.tambola.model.Ticket;

import java.util.List;

public interface ClaimValidator {
    ClaimStatus validateClaim(Ticket ticket, List<Integer> announcedNumbers);
}
