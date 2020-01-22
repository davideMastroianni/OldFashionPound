package it.md.ofp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TestOldPound {

    @Test
    public void toString_shouldReturnCorrectString() {
        // SETUP
        Integer pounds = 10;
        Integer shillings = 5;
        Integer pence = 18;
        OldPound sut = new OldPound(pounds, shillings, pence);
        // ACT
        String parsedOldPound = sut.toString();
        // VERIFY
        assertThat(parsedOldPound).isEqualTo("10p 5s 18d");
    }


}
