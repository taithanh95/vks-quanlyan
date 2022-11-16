package com.bitsco.vks.constant;

public enum GeneralModelStatus {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    GeneralModelStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
