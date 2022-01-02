package org.bambrikii.expr.tiny.algo.timeperiod;

public class TimePeriodElement {
    private final int val;
    private final TimePeriodType type;

    public TimePeriodElement(int val, TimePeriodType type) {
        this.val = val;
        this.type = type;
    }

    public int getVal() {
        return val;
    }

    public TimePeriodType getType() {
        return type;
    }
}
