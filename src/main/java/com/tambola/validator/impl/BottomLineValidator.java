package com.tambola.validator.impl;

import com.tambola.constants.ApplicationConstants;
import com.tambola.enums.ClaimStatus;

public class BottomLineValidator extends LineValidator {

    @Override
    protected int getRowIndex() {
        return ApplicationConstants.BOTTOM_ROW;
    }

    @Override
    protected ClaimStatus getClaimStatus(int crossedCount, boolean lastNumberContained) {
        return ClaimStatus.isAccepted(crossedCount == ApplicationConstants.COLUMN_SIZE && lastNumberContained);
    }
}
