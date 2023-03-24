package org.bambrikii.tiny.expr.parser;

import org.bambrikii.tiny.expr.algo.Operator;

import java.util.LinkedList;

public class ExpressionParserContext {
    private final String expr;
    private int pos = 0;
    private final LinkedList<Operator> vals = new LinkedList<>();
    private final LinkedList<OperatorParser> parserOps = new LinkedList<>();

    public ExpressionParserContext(String expr) {
        this.expr = expr;
    }

    public char charAt(int pos) {
        return expr.charAt(pos);
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    public boolean isEol() {
        return isEol(pos);
    }

    public boolean isEol(int pos) {
        return pos >= expr.length();
    }

    public void pushVal(Operator val) {
        vals.push(val);
    }

    public LinkedList<Operator> getVals() {
        return vals;
    }

    public Operator popVal() {
        return vals.pop();
    }

    public boolean hasParserOps() {
        return !parserOps.isEmpty();
    }

    public OperatorParser lastParserOp() {
        return parserOps.peek();
    }

    public OperatorParser popParserOp() {
        return parserOps.pop();
    }

    public void pushParserOp(OperatorParser parser) {
        parserOps.push(parser);
    }
}
