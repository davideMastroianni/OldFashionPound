package it.md.ofp;

public class OfpOperation {

    private OldPound op_1;
    private OldPound op_2;
    private OfpBasicArithmetic basicArithmetic;

    public OfpOperation(OldPound op_1, OldPound op_2, OfpBasicArithmetic basicArithmetic) {
        this.op_1 = op_1;
        this.op_2 = op_2;
        this.basicArithmetic = basicArithmetic;
    }

    public OldPound calculate() {
        return this.basicArithmetic.calculate(this.op_1, this.op_2);
    }
}
