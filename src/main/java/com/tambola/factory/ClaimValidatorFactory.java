package com.tambola.factory;

import com.tambola.enums.ClaimType;
import com.tambola.validator.ClaimValidator;
import com.tambola.validator.impl.*;

import java.util.EnumMap;

public class ClaimValidatorFactory {
    private static final EnumMap<ClaimType, ClaimValidator> claimMap = new EnumMap<>(ClaimType.class);

    static {
        claimMap.put(ClaimType.TOP_LINE, new TopLineValidator());
        claimMap.put(ClaimType.MIDDLE_LINE, new MiddleLineValidator());
        claimMap.put(ClaimType.BOTTOM_LINE, new BottomLineValidator());
        claimMap.put(ClaimType.EARLY_FIVE, new EarlyFiveValidator());
        claimMap.put(ClaimType.FULL_HOUSE, new FullHouseValidator());
    }

    public static ClaimValidator getClaimType(ClaimType claimType) {
        return claimMap.get(claimType);
    }
}
