package it.md.ofp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import it.md.ofp.basicArithmetic.Diff;
import it.md.ofp.basicArithmetic.Div;
import it.md.ofp.basicArithmetic.Mul;
import it.md.ofp.basicArithmetic.Sum;
import org.junit.Test;

public class TestOfpBasicArithmetic {

    @Test
    public void sum_calculate_shouldReturnCorrectlyChangedOldPound() {
        // SETUP
        OldPound op_1 = new OldPound(5, 17 ,8);
        OldPound op_2 = new OldPound(3, 4 ,10);
        Sum sum = new Sum(op_1, op_2);
        // ACT
        OldPound result = sum.calculate();
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(9);
        assertThat(result.getShillings()).isEqualTo(2);
        assertThat(result.getPence()).isEqualTo(6);
    }

    @Test
    public void sum_calculate_shouldReturnEmptyOldPound_withEmptyOperators() {
        // SETUP
        OldPound op_1 = new OldPound(0, 0 ,0);
        OldPound op_2 = new OldPound(0, 0 ,0);
        Sum sum = new Sum(op_1, op_2);
        // ACT
        OldPound result = sum.calculate();
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(0);
        assertThat(result.getShillings()).isEqualTo(0);
        assertThat(result.getPence()).isEqualTo(0);
    }

    @Test
    public void diff_calculate_shouldReturnCorrectlyChangedOldPound_withNoNegative() {
        // SETUP
        OldPound op_1 = new OldPound(5, 17 ,8);
        OldPound op_2 = new OldPound(3, 4 ,10);
        Diff sut = new Diff(op_1, op_2);
        // ACT
        OldPound result = sut.calculate();
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(2);
        assertThat(result.getShillings()).isEqualTo(12);
        assertThat(result.getPence()).isEqualTo(10);
    }

    @Test
    public void diff_calculate_shouldReturnCorrectlyChangedOldPound_withPenceNegative() {
        // SETUP
        OldPound op_1 = new OldPound(5, 17 ,8);
        OldPound op_2 = new OldPound(3, 4 ,16);
        Diff sut = new Diff(op_1, op_2);
        // ACT
        OldPound result = sut.calculate();
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(2);
        assertThat(result.getShillings()).isEqualTo(13);
        assertThat(result.getPence()).isEqualTo(0);
        assertThat(result.getRemainder().getPence()).isEqualTo(8);
    }

    @Test
    public void diff_calculate_shouldReturnCorrectlyChangedOldPound_withSomeNegative() {
        // SETUP
        OldPound op_1 = new OldPound(5, 17 ,8);
        OldPound op_2 = new OldPound(8, 4 ,16);
        Diff sut = new Diff(op_1, op_2);
        // ACT
        OldPound result = sut.calculate();
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(0);
        assertThat(result.getShillings()).isEqualTo(0);
        assertThat(result.getPence()).isEqualTo(0);
        assertThat(result.getRemainder().getPounds()).isEqualTo(2);
        assertThat(result.getRemainder().getShillings()).isEqualTo(7);
        assertThat(result.getRemainder().getPence()).isEqualTo(8);
    }

    @Test
    public void mul_calculate_shouldReturnCorrectlyChangedOldPound() {
        // SETUP
        OldPound op_1 = new OldPound(5, 17 ,8);
        int op_2 = 2;
        Mul sut = new Mul(op_1, op_2);
        // ACT
        OldPound result = sut.calculate();
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(11);
        assertThat(result.getShillings()).isEqualTo(15);
        assertThat(result.getPence()).isEqualTo(4);
    }

    @Test
    public void mul_calculate_shouldReturnZero_withIntZero() {
        // SETUP
        OldPound op_1 = new OldPound(5, 17 ,8);
        int op_2 = 0;
        Mul sut = new Mul(op_1, op_2);
        // ACT
        OldPound result = sut.calculate();
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(0);
        assertThat(result.getShillings()).isEqualTo(0);
        assertThat(result.getPence()).isEqualTo(0);
    }

    @Test
    public void div_calculate_shouldReturnCorrectlyChangedOldPound() {
        // SETUP
        OldPound op_1 = new OldPound(5, 17 ,8);
        int op_2 = 3;
        Div sut = new Div(op_1, op_2);
        // ACT
        OldPound result = sut.calculate();
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(1);
        assertThat(result.getShillings()).isEqualTo(19);
        assertThat(result.getPence()).isEqualTo(2);
        assertThat(result.getRemainder().getPounds()).isEqualTo(0);
        assertThat(result.getRemainder().getShillings()).isEqualTo(0);
        assertThat(result.getRemainder().getPence()).isEqualTo(2);
    }

    @Test
    public void div_calculate_shouldThrowException_withZero() {
        // SETUP
        OldPound op_1 = new OldPound(5, 17 ,8);
        int op_2 = 0;
        Div sut = new Div(op_1, op_2);
        // ACT & VERIFY
        assertThatThrownBy(sut::calculate).isInstanceOf(ArithmeticException.class).hasMessage("/ by zero");

    }

}
