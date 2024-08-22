package com.tambola.manager;

import com.tambola.enums.ClaimStatus;
import com.tambola.enums.ClaimType;
import com.tambola.factory.ClaimValidatorFactory;
import com.tambola.model.Ticket;
import com.tambola.validator.ClaimValidator;

import java.util.List;

public class TambolaManager {
    private static TambolaManager tambolaManager;
    private Ticket ticket;
    private final ClaimValidatorFactory claimValidatorFactory;
    private TambolaManager() {
        claimValidatorFactory = new ClaimValidatorFactory();
    }

    public static TambolaManager getTambolaManager() {
        if (tambolaManager == null) {
            synchronized(TambolaManager.class) {
                if (tambolaManager == null)
                    tambolaManager = new TambolaManager();
            }
        }
        return tambolaManager;
    }
    public void initializeTicket(List<List<Integer>> numbers) {
        ticket = new Ticket(numbers);
    }
    public ClaimStatus validateClaim(ClaimType claimType, List<Integer> announcedNumbers) {
        ClaimValidator claimValidator = this.claimValidatorFactory.getClaimType(claimType);
        return claimValidator.validateClaim(ticket, announcedNumbers);
    }
}
