package org.bambrikii.expr.tiny.parser.vals.period;

import java.util.List;

public class PeriodMatcher {
    public final String ch;
    public final List<PeriodMatcher> more;

    public PeriodMatcher(String ch, PeriodMatcher... more) {
        this.ch = ch;
        this.more = List.of(more);
    }
}
