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

    public OldPound(int pounds, int shillings, int pence) {
        this.pounds = pounds;
        this.shillings = shillings;
        this.pence = pence;
    }

    @Override
    public String toString() {
        return pounds + "p " + shillings + "s " + pence + "d";
    }
}
