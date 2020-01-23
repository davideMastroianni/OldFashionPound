package it.md.ofp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TestOldPound {

    @Test
    public void toString_shouldReturnCorrectString() {
        // SETUP
        int pounds = 10;
        int shillings = 5;
        int pence = 18;
        OldPound sut = new OldPound(pounds, shillings, pence);
        // ACT
        String parsedOldPound = sut.toString();
        // VERIFY
        assertThat(parsedOldPound).isEqualTo("10p 5s 18d");
    }

    @Test
    public void optimizeValues_shouldConvertPenceToShillings() {
        // SETUP
        int pounds = 18;
        int shillings = 5;
        int pence = 60;
        OldPound sut = new OldPound(pounds, shillings, pence);
        // ACT
        sut.optimizeValues();
        // VERIFY
        assertThat(sut.getPounds()).isEqualTo(18);
        assertThat(sut.getShillings()).isEqualTo(10);
        assertThat(sut.getPence()).isEqualTo(0);
    }

    @Test
    public void optimizeValues_shouldConvertShillingsToPounds() {
        // SETUP
        int pounds = 18;
        int shillings = 83;
        int pence = 0;
        OldPound sut = new OldPound(pounds, shillings, pence);
        // ACT
        sut.optimizeValues();
        // VERIFY
        assertThat(sut.getPounds()).isEqualTo(22);
        assertThat(sut.getShillings()).isEqualTo(3);
        assertThat(sut.getPence()).isEqualTo(0);
    }

    @Test
    public void optimizeValues_shouldConvertPenceToShillingsToPounds() {
        // SETUP
        int pounds = 18;
        int shillings = 99;
        int pence = 67;
        OldPound sut = new OldPound(pounds, shillings, pence);
        // ACT
        sut.optimizeValues();
        // VERIFY
        assertThat(sut.getPounds()).isEqualTo(23);
        assertThat(sut.getShillings()).isEqualTo(4);
        assertThat(sut.getPence()).isEqualTo(7);
    }


}
