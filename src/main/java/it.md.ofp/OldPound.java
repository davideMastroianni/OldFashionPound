package it.md.ofp;

import lombok.Getter;
import lombok.Setter;

/**
 * MISSION: representation of pre-1970 UK prices.
 */
public class OldPound {

    @Setter @Getter
    private int pounds;
    @Setter @Getter
    private int shillings;
    @Setter @Getter
    private int pence;
    @Setter @Getter
    private int remainderPounds;
    @Setter @Getter
    private int remainderShillings;
    @Setter @Getter
    private int remainderPence;

    public OldPound(int pounds, int shillings, int pence) {
        this.pounds = pounds;
        this.shillings = shillings;
        this.pence = pence;
        this.remainderPounds = 0;
        this.remainderShillings = 0;
        this.remainderPence = 0;
    }

    @Override
    public String toString() {
        if (remainderPence == 0 && remainderShillings == 0 && remainderPence == 0) {
            return pounds + "p " + shillings + "s " + pence + "d";
        } else {
            return pounds + "p " + shillings + "s " + pence + "d" + " (-" + remainderPence + "p -" + remainderShillings + "s -" + remainderPence + "d)";
        }
    }

    public void setRemainders(int remainderPounds, int remainderShillings, int remainderPence) {
        this.remainderPounds = remainderPounds;
        this.remainderShillings = remainderShillings;
        this.remainderPence = remainderPence;
    }
}
