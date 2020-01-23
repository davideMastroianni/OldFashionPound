package it.md.ofp.basicArithmetic;

import it.md.ofp.OldPound;

/**
 * MISSION: provide an implementation of multiplication operation between an OldPound objects and a int.
 */
public class Mul implements OfpBasicArithmetic {

    private OldPound op_1;
    private int op_2;

    public Mul(OldPound op_1, int op_2) {
        this.op_1 = op_1;
        this.op_2 = op_2;
    }

    @Override
    public OldPound calculate() {
        int pounds = this.op_1.getPounds() * this.op_2;
        int shillings = this.op_1.getShillings() * this.op_2;
        int pence = this.op_1.getPence() * this.op_2;
        OldPound result = new OldPound(pounds, shillings, pence);
        result.optimizeValues();
        return result;
    }
}
