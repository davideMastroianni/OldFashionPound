package it.md.ofp;

import lombok.Getter;
import lombok.Setter;

/**
 * MISSION: representation of pre-1970 UK prices.
 */
public class OldPound {

    @Getter
    private int pounds;
    @Getter
    private int shillings;
    @Getter
    private int pence;
    @Setter @Getter
    private OldPound remainder;

    public OldPound(int pounds, int shillings, int pence) {
        this.pounds = pounds;
        this.shillings = shillings;
        this.pence = pence;
    }

    @Override
    public String toString() {
        String moneyTalk;
        if (this.pounds > 0) {
            moneyTalk = pounds + "p " + shillings + "s " + pence + "d";
        } else if (this.shillings > 0) {
            moneyTalk = shillings + "s " + pence + "d";
        } else {
            moneyTalk = pence + "d";
        }
        if (remainder != null && !remainder.isZero()) {
            moneyTalk += " (" + remainder.toString() + ")";
        }
        return moneyTalk;
    }

    public boolean isZero() {
        return this.pounds == 0 && this.shillings == 0 && this.pence == 0;
    }

    public void optimizeValues() {
        int actualPence = this.pence % 12;
        int penceToShillings = this.pence / 12;
        int actualShillings = (this.shillings + penceToShillings) % 20;
        int shillingsToPounds = (this.shillings + penceToShillings) / 20;
        int actualPounds = this.pounds + shillingsToPounds;
        // SET ATTRIBUTES
        this.pence = actualPence;
        this.shillings = actualShillings;
        this.pounds = actualPounds;
    }
}
