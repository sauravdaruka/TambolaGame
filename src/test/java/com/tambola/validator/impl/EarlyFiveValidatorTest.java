package com.tambola.validator.impl;

import com.tambola.enums.ClaimStatus;
import com.tambola.enums.ClaimType;
import com.tambola.manager.TambolaManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class EarlyFiveValidatorTest {
    private TambolaManager tambolaManager;

    @BeforeEach
    public void setup() {
        tambolaManager = TambolaManager.getTambolaManager();
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(4, 16, null, null, 48, null, 63, 76, null),
                Arrays.asList(7, null, 23, 38, null, 52, null, null, 80),
                Arrays.asList(9, null, 25, null, null, 56, 64, null, 83)
        );
        tambolaManager.initializeTicket(numbers);
    }


    @Test
    public void testEarlyFiveClaimAccepted() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76);
        Assertions.assertEquals(ClaimStatus.ACCEPTED, tambolaManager.validateClaim(ClaimType.EARLY_FIVE, announcedNumbers));
    }

    @Test
    public void testEarlyFiveClaimRejectedDueToLateClaim() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76, 12);
        Assertions.assertEquals(ClaimStatus.REJECTED, tambolaManager.validateClaim(ClaimType.EARLY_FIVE, announcedNumbers));
    }

}