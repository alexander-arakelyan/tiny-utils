package org.bambrikii.expr.tiny.algo.timeperiod;

public class TimePeriodElement {
    private final int num;
    private final TimePeriodType type;

    public TimePeriodElement(int num, TimePeriodType type) {
        this.num = num;
        this.type = type;
    }


    public int getNum() {
        return num;
    }

    public TimePeriodType getType() {
        return type;
    }
}
