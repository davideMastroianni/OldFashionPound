package it.md.ofp.basicArithmetic;

import it.md.ofp.OldPound;

public class BasicArithmeticFactory {

    public static OfpBasicArithmetic getBasicArithmetic(OfpArithmeticEnum oae, OldPound op_1, OldPound op_2) throws Exception {
        if (oae == OfpArithmeticEnum.SUM) {
            return new Sum(op_1, op_2);
        } else if (oae == OfpArithmeticEnum.DIFF) {
            return new Diff(op_1, op_2);
        } else {
            throw new Exception("Operator MUL and DIV MUST have left term of type OldPound and right term of type int");
        }
    }

    public static OfpBasicArithmetic getBasicArithmetic(OfpArithmeticEnum oae, OldPound op_1, int op_2) throws Exception {
        if (oae == OfpArithmeticEnum.MUL) {
            return new Mul(op_1, op_2);
        } else if (oae == OfpArithmeticEnum.DIV) {
            return new Div(op_1, op_2);
        } else  {
            throw new Exception("Operator SUM and DIFF want both terms to be type OldPound");
        }
    }
}
