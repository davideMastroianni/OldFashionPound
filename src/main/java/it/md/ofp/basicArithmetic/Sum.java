package it.md.ofp.basicArithmetic;

import it.md.ofp.OldPound;

/**
 * MISSION: provide an implementation of sum operation between an OldPound objects and a int.
 */
public class Sum implements OfpBasicArithmetic {

    private OldPound op_1;
    private OldPound op_2;

    public Sum(OldPound op_1, OldPound op_2) {
        this.op_1 = op_1;
        this.op_2 = op_2;
    }

    @Override
    public OldPound calculate() {
        int pence = this.op_1.getPence() + this.op_2.getPence();
        int shillings = this.op_1.getShillings() + this.op_2.getShillings();
        int pounds = this.op_1.getPounds() + this.op_2.getPounds();
        OldPound result = new OldPound(pounds, shillings, pence);
        result.optimizeValues();
        return result;
    }
}
