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
    @Setter @Getter
    private boolean isDebt = false;

    public OldPound(int pounds, int shillings, int pence) {
        this.pounds = pounds;
        this.shillings = shillings;
        this.pence = pence;
    }

    @Override
    public String toString() {
        String moneyTalk;
        if (this.pounds > 0) {
            moneyTalk = getValueWithSign(pounds) + "p " + getValueWithSign(shillings) + "s " + getValueWithSign(pence) + "d";
        } else if (this.shillings > 0) {
            moneyTalk = getValueWithSign(shillings) + "s " + getValueWithSign(pence) + "d";
        } else {
            moneyTalk = getValueWithSign(pence) + "d";
        }
        if (remainder != null && !remainder.isZero()) {
            moneyTalk += " (" + remainder.toString() + ")";
        }
        return moneyTalk;
    }

    /**
     * Transform given int value into String.
     * Value become negative if attribute isDebt is true.
     * Zero value has no sign.
     * @param value int
     * @return boolean
     */
    private String getValueWithSign(int value) {
        if (this.isDebt && value != 0) {
            return "-"+value;
        } else {
            return Integer.toString(value);
        }

    }

    /**
     * Check if all primary attributes (pounds, shillings and pence) have value zero.
     * @return boolean
     */
    public boolean isZero() {
        return this.pounds == 0 && this.shillings == 0 && this.pence == 0;
    }

    /**
     * Change pence into shillings and shillings into pounds.
     * Based on conversion tariff of pre-1970 UK
     * 12 pence -> 1 shillings
     * 20 shillings -> 1 pound
     */
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
