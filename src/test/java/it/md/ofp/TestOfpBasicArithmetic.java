package it.md.ofp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TestOfpBasicArithmetic {

    @Test
    public void sum_calculate_shouldReturnCorrectlyChangedOldPound() {
        // SETUP
        Sum sum = new Sum();
        OldPound op_1 = new OldPound(5, 17 ,8);
        OldPound op_2 = new OldPound(3, 4 ,10);
        // ACT
        OldPound result = sum.calculate(op_1, op_2);
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(9);
        assertThat(result.getShillings()).isEqualTo(2);
        assertThat(result.getPence()).isEqualTo(6);
    }

    @Test
    public void sum_calculate_shouldReturnEmptyOldPound_withEmptyOperators() {
        // SETUP
        Sum sum = new Sum();
        OldPound op_1 = new OldPound(0, 0 ,0);
        OldPound op_2 = new OldPound(0, 0 ,0);
        // ACT
        OldPound result = sum.calculate(op_1, op_2);
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(0);
        assertThat(result.getShillings()).isEqualTo(0);
        assertThat(result.getPence()).isEqualTo(0);
    }

    @Test
    public void diff_calculate_shouldReturnCorrectlyChangedOldPound_withNoNegative() {
        // SETUP
        Diff sut = new Diff();
        OldPound op_1 = new OldPound(5, 17 ,8);
        OldPound op_2 = new OldPound(3, 4 ,8);
        // ACT
        OldPound result = sut.calculate(op_1, op_2);
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(2);
        assertThat(result.getShillings()).isEqualTo(13);
        assertThat(result.getPence()).isEqualTo(0);
    }

    @Test
    public void diff_calculate_shouldReturnCorrectlyChangedOldPound_withPenceNegative() {
        // SETUP
        Diff sut = new Diff();
        OldPound op_1 = new OldPound(5, 17 ,8);
        OldPound op_2 = new OldPound(3, 4 ,16);
        // ACT
        OldPound result = sut.calculate(op_1, op_2);
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(2);
        assertThat(result.getShillings()).isEqualTo(13);
        assertThat(result.getPence()).isEqualTo(0);
        assertThat(result.getRemainderPence()).isEqualTo(8);
    }

    @Test
    public void diff_calculate_shouldReturnCorrectlyChangedOldPound_withSomeNegative() {
        // SETUP
        Diff sut = new Diff();
        OldPound op_1 = new OldPound(5, 17 ,8);
        OldPound op_2 = new OldPound(8, 4 ,16);
        // ACT
        OldPound result = sut.calculate(op_1, op_2);
        // VERIFY
        assertThat(result).isNotNull();
        assertThat(result.getPounds()).isEqualTo(0);
        assertThat(result.getShillings()).isEqualTo(0);
        assertThat(result.getPence()).isEqualTo(0);
        assertThat(result.getRemainderPence()).isEqualTo(8);
        assertThat(result.getRemainderShillings()).isEqualTo(7);
        assertThat(result.getRemainderPounds()).isEqualTo(2);
    }
}
