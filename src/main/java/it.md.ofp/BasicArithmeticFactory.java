package it.md.ofp;

public class BasicArithmeticFactory {

    public static OfpBasicArithmetic getBasicArithmetic(OfpArithmeticEnum oae) throws Exception {
        if (oae == OfpArithmeticEnum.SUM) {
            return new Sum();
        } else {
            throw new Exception("Basic Arithmetic not recognized");
        }
    }
}
