package com.tambola.enums;

public enum ClaimStatus {
    ACCEPTED ("Accepted", true),
    REJECTED ("Rejected", false);

    private final String status;
    private final boolean isAccepted;

    ClaimStatus(String status, boolean isAccepted) {
        this.status = status;
        this.isAccepted = isAccepted;
    }

    public static ClaimStatus getClaimStatusByIsAccepted(boolean isAccepted) {
        for (ClaimStatus claimStatus : ClaimStatus.values()) {
            if (claimStatus.isAccepted == isAccepted)
                return claimStatus;
        }
        return ClaimStatus.REJECTED;
    }
}

