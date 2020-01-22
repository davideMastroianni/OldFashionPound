package it.md.ofp;

import lombok.Getter;
import lombok.Setter;

/**
 * MISSION: representation of pre-1970 UK prices.
 */
public class OldPound {

    @Setter @Getter
    private Integer pounds;
    @Setter @Getter
    private Integer shillings;
    @Setter @Getter
    private Integer pence;

    public OldPound(Integer pounds, Integer shillings, Integer pence) {
        this.pounds = pounds;
        this.shillings = shillings;
        this.pence = pence;
    }

    @Override
    public String toString() {
        return pounds + "p " + shillings + "s " + pence + "d";
    }
}
