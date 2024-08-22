package com.tambola.factory;

import com.tambola.enums.ClaimType;
import com.tambola.validator.ClaimValidator;
import com.tambola.validator.impl.*;

import java.util.EnumMap;

public class ClaimValidatorFactory {
    public ClaimValidatorFactory() {
        initializeClaimMap();
    }
    private static EnumMap<ClaimType, ClaimValidator> claimMap;

    private void initializeClaimMap() {
        claimMap = new EnumMap<>(ClaimType.class);

        claimMap.put(ClaimType.TOP_LINE, new TopLineValidator());
        claimMap.put(ClaimType.MIDDLE_LINE, new MiddleLineValidator());
        claimMap.put(ClaimType.BOTTOM_LINE, new BottomLineValidator());
        claimMap.put(ClaimType.EARLY_FIVE, new EarlyFiveValidator());
        claimMap.put(ClaimType.FULL_HOUSE, new FullHouseValidator());
    }

    public ClaimValidator getClaimType(ClaimType claimType) {
        return claimMap.get(claimType);
    }
}
