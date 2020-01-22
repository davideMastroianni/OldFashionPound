package it.md.ofp;

import lombok.Getter;

class RawOperationParser {

    @Getter private String[] rawOperation;

    public RawOperationParser(String[] rawOperation) {
        this.rawOperation = rawOperation;
    }

    public OfpArithmeticEnum parseOperator() throws Exception {
        String rawOperator = rawOperation[3];
        switch (rawOperator) {
            case "+":
                return OfpArithmeticEnum.SUM;
            case "-":
                return OfpArithmeticEnum.DIFF;
            case "*":
                return OfpArithmeticEnum.MUL;
            case "/":
                return OfpArithmeticEnum.DIV;
            default:
                throw new Exception("Malformed raw operation.");
        }
    }

    public OldPound parseLeftPound() {
        String rawPounds = rawOperation[0];
        String rawShillings = rawOperation[1];
        String rawPence = rawOperation[2];
        return parseOldPound(rawPounds, rawShillings, rawPence);
    }

    public OldPound parseRightPound() {
        String rawPounds = rawOperation[4];
        String rawShillings = rawOperation[5];
        String rawPence = rawOperation[6];
        return parseOldPound(rawPounds, rawShillings, rawPence);
    }

    private OldPound parseOldPound(String rawPounds, String rawShillings, String rawPence) {
        int pounds = rawStringToInt(rawPounds);
        int shillings = rawStringToInt(rawShillings);
        int pence = rawStringToInt(rawPence);
        return new OldPound(pounds, shillings, pence);
    }

    private int rawStringToInt(String rawString) {
        String stringInt = rawString.substring(0, rawString.length() - 1);
        return Integer.parseInt(stringInt);
    }
}
