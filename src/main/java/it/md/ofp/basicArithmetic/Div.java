package it.md.ofp.basicArithmetic;

import it.md.ofp.OldPound;

/**
 * MISSION: provide an implementation of division operation between an OldPound object and a int.
 * Any remainder value is stored as remainder into OldPound result object.
 */
public class Div implements OfpBasicArithmetic {

    private OldPound op_1;
    private int op_2;

    public Div(OldPound op_1, int op_2) {
        this.op_1 = op_1;
        this.op_2 = op_2;
    }

    @Override
    public OldPound calculate() {
        // calculate pounds
        int pounds = this.op_1.getPounds() / this.op_2;
        int remainderPounds = this.op_1.getPounds() % this.op_2;
        // calculate shillings
        int shillings = this.op_1.getShillings() + (remainderPounds * 20);
        int actualShillings = shillings / this.op_2;
        int remainderShillings = shillings % this.op_2;
        // calculate pence
        int pence = this.op_1.getPence() + (remainderShillings * 12);
        int actualPence = pence / this.op_2;
        int remainderPence = pence % this.op_2;
        OldPound result = new OldPound(pounds, actualShillings, actualPence);
        // optimize values
        int actualRemainderPence = remainderPence % 12;
        int remainderPenceToShillings = (remainderPence - actualRemainderPence) / 12;
        int actualRemainderShillings = remainderPenceToShillings % 20;
        int actualRemainderPounds = (remainderPenceToShillings - actualRemainderShillings) / 20;
        OldPound remainder = new OldPound(actualRemainderPounds, actualRemainderShillings, actualRemainderPence);
        remainder.optimizeValues();
        result.setRemainder(remainder);
        return result;
    }
}
