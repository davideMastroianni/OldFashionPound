package it.md.ofp;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;


public class TestPriceArithmetic {

    @Test
    public void calculateExpression_shouldSum_withSumExpression() {
        // SETUP
        String[] rawExpression = {"5p", "17s", "8d", "+", "3p", "4s", "10d"};
        // ACT
        String result = PriceArithmetic.calculateExpressionFromStandardInput(rawExpression);
        // VERIFY
        assertThat(result).isEqualTo("9p 2s 6d");
    }

    @Test
    public void calculateExpression_shouldDiff_withDiffExpression() {
        // SETUP
        String[] rawExpression = {"5p", "17s", "8d", "-", "3p", "4s", "10d"};
        // ACT
        String result = PriceArithmetic.calculateExpressionFromStandardInput(rawExpression);
        // VERIFY
        assertThat(result).isEqualTo("2p 12s 10d");
    }

    @Test
    public void calculateExpression_shouldMul_withMulExpression() {
        // SETUP
        String[] rawExpression = {"5p", "17s", "8d", "*", "2"};
        // ACT
        String result = PriceArithmetic.calculateExpressionFromStandardInput(rawExpression);
        // VERIFY
        assertThat(result).isEqualTo("11p 15s 4d");
    }

    @Test
    public void calculateExpression_shouldDiv_withDivExpression() {
        // SETUP
        String[] rawExpression = {"5p", "17s", "8d", "/", "3"};
        // ACT
        String result = PriceArithmetic.calculateExpressionFromStandardInput(rawExpression);
        // VERIFY
        assertThat(result).isEqualTo("1p 19s 2d (2d)");
    }


}
