package org.bambrikii.expression.tiny.parser;

import org.bambrikii.expression.tiny.algo.Operation;

import java.util.LinkedList;

public class ExpressionParserContext {
    private final String expr;
    private int pos = 0;
    private final LinkedList<Operation> vals = new LinkedList<>();
    private final LinkedList<Operation> ops = new LinkedList<>();
    private final LinkedList<OperationParser> parserOps = new LinkedList<>();

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

    public void pushVal(Operation val) {
        vals.push(val);
    }

    public void pushOp(Operation operation) {
        this.ops.push(operation);
    }

    public LinkedList<Operation> getVals() {
        return vals;
    }

    public LinkedList<Operation> getOps() {
        return ops;
    }

    public Operation popVal() {
        return vals.pop();
    }

    public boolean hasParserOps() {
        return !parserOps.isEmpty();
    }

    public OperationParser lastParserOp() {
        return parserOps.peek();
    }

    public OperationParser popParserOp() {
        return parserOps.pop();
    }

    public void pushParserOp(OperationParser parser) {
        parserOps.push(parser);
    }
}
