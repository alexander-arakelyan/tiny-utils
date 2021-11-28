package org.bambrikii.expression.tiny.algo;

public class PeriodElement {
    private final int num;
    private final PeriodType type;

    public PeriodElement(int num, PeriodType type) {
        this.num = num;
        this.type = type;
    }


    public int getNum() {
        return num;
    }

    public PeriodType getType() {
        return type;
    }
}
