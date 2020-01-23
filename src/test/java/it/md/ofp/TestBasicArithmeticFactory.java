package it.md.ofp;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import it.md.ofp.basicArithmetic.BasicArithmeticFactory;
import it.md.ofp.basicArithmetic.OfpArithmeticEnum;
import it.md.ofp.basicArithmetic.OfpBasicArithmetic;
import it.md.ofp.basicArithmetic.Sum;
import org.junit.Test;

public class TestBasicArithmeticFactory {

    @Test
    public void getBasicArithmetic_shouldReturnSumObject_withSumEnum() {
        // SETUP
        OfpArithmeticEnum operator = OfpArithmeticEnum.SUM;
        OldPound op_1 = mock(OldPound.class);
        OldPound op_2 = mock(OldPound.class);
        // ACT
        try {
            OfpBasicArithmetic basicArithmetic = BasicArithmeticFactory.getBasicArithmetic(operator, op_1, op_2);
            // VERIFY
            assertThat(basicArithmetic).isNotNull();
            assertThat(basicArithmetic).isInstanceOf(Sum.class);
        } catch (Exception e) {
            fail("Should not throw exception with Enum %s", operator);
        }
    }

    @Test
    public void getBasicArithmetic_shouldThrowException_withWrongEnum() {
        // SETUP
        OfpArithmeticEnum operator = mock(OfpArithmeticEnum.class);
        OldPound op_1 = mock(OldPound.class);
        OldPound op_2 = mock(OldPound.class);
        // ACT & VERIFY
        assertThatThrownBy(() -> {
            OfpBasicArithmetic basicArithmetic = BasicArithmeticFactory.getBasicArithmetic(operator, op_1, op_2);
        }).isInstanceOf(Exception.class).hasMessage("Basic Arithmetic not recognized");
    }

}
