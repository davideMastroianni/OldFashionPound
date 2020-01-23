package it.md.ofp;

import it.md.ofp.basicArithmetic.OfpArithmeticEnum;
import lombok.Getter;

class RawOperationParser {

    @Getter private String[] rawOperation;
    @Getter private OldPound leftOperation;
    @Getter private OldPound rightOperationPound;
    @Getter private OfpArithmeticEnum operator;
    @Getter private int rightOperationInteger;

    RawOperationParser(String[] rawOperation) {
        this.rawOperation = rawOperation;
    }

    void parse() throws Exception {
        validateRawOperationLength();
        parseOperator();
        validateRawOperationType(this.operator);
        parseLeftOperation();
        parseRightOperation(this.operator);
    }

    private void validateRawOperationLength() throws Exception {
        if (!(rawOperation.length == 5 || rawOperation.length == 7)) {
            throw new Exception("Raw operation is malformed. It's required to be in this form \"Xp Ys Zd [*|/] K\" or \"Xp Ys Zd [+|-] Ap Bs Cd\"");
        }
    }

    private void parseOperator() throws Exception {
        String rawOperator = rawOperation[3];
        if (rawOperator.equals("+")) {
            this.operator = OfpArithmeticEnum.SUM;
        } else if (rawOperator.equals("-")) {
            this.operator = OfpArithmeticEnum.DIFF;
        } else if (rawOperator.equals("*")) {
            this.operator = OfpArithmeticEnum.MUL;
        } else if (rawOperator.equals("/")) {
            this.operator = OfpArithmeticEnum.DIV;
        } else {
            throw new Exception("Malformed expression: operator " + rawOperator + " is not supported.");
        }
    }

    private void validateRawOperationType(OfpArithmeticEnum operator) throws Exception {
        if (operator == OfpArithmeticEnum.SUM || operator == OfpArithmeticEnum.DIFF) {
            if (rawOperation.length != 7) {
                throw new Exception("Raw operation is malformed for operator / and *. It required to be in this form \"Xp Ys Zd [+|-] Ap Bs Cd\"");
            }
        } else {
            if (rawOperation.length != 5) {
                throw new Exception("Raw operation is malformed for operator / and *. It required to be in this form \"Xp Ys Zd [*|/] K\"");
            }
        }
    }

    private void parseLeftOperation() {
        String rawPounds = rawOperation[0];
        String rawShillings = rawOperation[1];
        String rawPence = rawOperation[2];
        this.leftOperation = parseOldPound(rawPounds, rawShillings, rawPence);
    }

    private void parseRightOperation(OfpArithmeticEnum operator) {
        if (operator == OfpArithmeticEnum.SUM || operator == OfpArithmeticEnum.DIFF) {
            String rawPounds = rawOperation[4];
            String rawShillings = rawOperation[5];
            String rawPence = rawOperation[6];
            this.rightOperationPound = parseOldPound(rawPounds, rawShillings, rawPence);
        } else {
            String rawInt = rawOperation[4];
            this.rightOperationInteger = Integer.parseInt(rawInt);
        }

    }

    private OldPound parseOldPound(String rawPounds, String rawShillings, String rawPence) {
        int pounds = rawValueToInt(rawPounds);
        int shillings = rawValueToInt(rawShillings);
        int pence = rawValueToInt(rawPence);
        return new OldPound(pounds, shillings, pence);
    }

    private int rawValueToInt(String rawString) {
        String stringInt = rawString.substring(0, rawString.length() - 1);
        return Integer.parseInt(stringInt);
    }


}
