package it.md.ofp;

import static java.lang.StrictMath.abs;

public class Diff implements OfpBasicArithmetic {

    @Override
    public OldPound calculate(OldPound op_1, OldPound op_2) {
        // calculate pounds
        int pounds = op_1.getPounds() - op_2.getPounds();
        int remainderPounds = 0;
        if (pounds < 0) {
            remainderPounds = abs(pounds);
            pounds = 0;
        }
        // calculate shillings
        int shillings = op_1.getShillings() - (op_2.getShillings() + remainderPounds * 20);
        int remainderShillings = 0;
        if (shillings < 0) {
            remainderShillings = abs(shillings);
            shillings = 0;
        }
        // calculate pence
        int pence = op_1.getPence() - (op_2.getPence() + remainderShillings * 12);
        int remainderPence = 0;
        if (pence < 0) {
            remainderPence = abs(pence);
            pence = 0;
        }
        OldPound result = new OldPound(pounds, shillings, pence);
        // optimize values
        int actualRemainderPence = remainderPence % 12;
        int remainderPenceToShillings = (remainderPence - actualRemainderPence) / 12;
        int actualRemainderShillings = remainderPenceToShillings % 20;
        int actualRemainderPounds = (remainderPenceToShillings - actualRemainderShillings) / 20;
        result.setRemainders(actualRemainderPounds, actualRemainderShillings, actualRemainderPence);
        return result;
    }
}
