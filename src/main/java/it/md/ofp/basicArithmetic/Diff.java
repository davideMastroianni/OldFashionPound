package it.md.ofp.basicArithmetic;

import it.md.ofp.OldPound;

import static java.lang.StrictMath.abs;

public class Diff implements OfpBasicArithmetic {

    private OldPound op_1;
    private OldPound op_2;

    public Diff(OldPound op_1, OldPound op_2) {
        this.op_1 = op_1;
        this.op_2 = op_2;
    }

    @Override
    public OldPound calculate() {
        // calculate pounds
        int pounds = this.op_1.getPounds() - this.op_2.getPounds();
        int remainderPounds = 0;
        if (pounds < 0) {
            remainderPounds = abs(pounds);
            pounds = 0;
        }
        // calculate shillings
        int shillings = (this.op_1.getShillings() + pounds * 20) - (this.op_2.getShillings() + remainderPounds * 20);
        int remainderShillings = 0;
        if (shillings < 0) {
            remainderShillings = abs(shillings);
            shillings = 0;
        }
        // calculate pence
        int pence = (this.op_1.getPence() + shillings * 12) - (this.op_2.getPence() + remainderShillings * 12);
        int remainderPence = 0;
        if (pence < 0) {
            remainderPence = abs(pence);
            pence = 0;
        }
        OldPound result = new OldPound(0, 0, pence);
        result.optimizeValues();
        if (remainderPence > 0) {
            OldPound reminder = new OldPound(0, 0, remainderPence);
            reminder.optimizeValues();
            reminder.setDebt(true);
            result.setRemainder(reminder);
        }
        return result;
    }
}
