package com.bitsco.vks.constant;

/*
    Trạng thái xử lý tin báo
 */
public enum SettlementStatus {

    NOT_BEING_SETTLED(1), // Chưa thực hiện
    BEING_SETTLED(2), // đang giải quyết
    SUSPENDED(3), // tạm đình chỉ
    SETTLED(4), // đã giải quyết
    OVERDUE(5); // quá hạn giải quyết
    ;

    private final int value;

    SettlementStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
