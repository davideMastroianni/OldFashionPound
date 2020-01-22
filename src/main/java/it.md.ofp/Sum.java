package it.md.ofp;

public class Sum implements ofpBasicArithmetic {

    @Override
    public OldPound calculate(OldPound op_1, OldPound op_2) {
        // calculate pence
        int pence = op_1.getPence() + op_2.getPence();
        int actualPence = pence % 12;
        int penceToShillings = (pence - actualPence) / 12;
        // calculate shillings
        int shillings = op_1.getShillings() + op_2.getShillings() + penceToShillings;
        int actualShillings = shillings % 20;
        int shillingsToPounds = (shillings - actualShillings) / 20;
        // calculate pounds
        int pounds = op_1.getPounds() + op_2.getPounds() + shillingsToPounds;
        return new OldPound(pounds, shillings, pence);
    }
}
