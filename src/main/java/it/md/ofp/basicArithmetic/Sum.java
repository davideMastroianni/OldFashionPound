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
        // calculate pence
        int pence = this.op_1.getPence() + this.op_2.getPence();
        int actualPence = pence % 12;
        int penceToShillings = (pence - actualPence) / 12;
        // calculate shillings
        int shillings = this.op_1.getShillings() + this.op_2.getShillings() + penceToShillings;
        int actualShillings = shillings % 20;
        int shillingsToPounds = (shillings - actualShillings) / 20;
        // calculate pounds
        int pounds = this.op_1.getPounds() + this.op_2.getPounds() + shillingsToPounds;
        return new OldPound(pounds, actualShillings, actualPence);
    }
}
