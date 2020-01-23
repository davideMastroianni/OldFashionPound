package it.md.ofp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TestRawOperationParser {

    @Test
    public void parse_shouldParseLeftOperation_withCorrectRawOperation() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "-", "3p", "4s", "10d"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT
        try {
            sut.parse();
        } catch (Exception e) {
            fail("Should not throw exception with correct raw operation");
        }
        OldPound op_1 = sut.getLeftOperation();
        // VERIFY
        assertThat(op_1.getPounds()).isEqualTo(5);
        assertThat(op_1.getShillings()).isEqualTo(17);
        assertThat(op_1.getPence()).isEqualTo(8);
    }

    @Test
    public void parse_shouldParseRightOperation_asOldPound_withSumRawOperation() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "+", "3p", "4s", "10d"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT
        try {
            sut.parse();
        } catch (Exception e) {
            fail("Should not throw exception with correct raw operation");
        }
        OldPound op_2 = sut.getRightOperationPound();
        // VERIFY
        assertThat(op_2.getPounds()).isEqualTo(3);
        assertThat(op_2.getShillings()).isEqualTo(4);
        assertThat(op_2.getPence()).isEqualTo(10);
    }

    @Test
    public void parse_shouldParseRightOperation_asInt_withMulRawOperation() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "*", "10"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT
        try {
            sut.parse();
        } catch (Exception e) {
            fail("Should not throw exception with correct raw operation");
        }
        int op_2 = sut.getRightOperationInteger();
        // VERIFY
        assertThat(op_2).isEqualTo(10);
    }

    @Test
    public void parse_shouldThrowException_withMalformedOperation() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "3p", "4s", "10d"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT & VERIFY
        assertThatThrownBy(sut::parse)
                .isInstanceOf(Exception.class)
                .hasMessage("Raw operation is malformed. It's required to be in this form \"Xp Ys Zd [*|/] K\" or \"Xp Ys Zd [+|-] Ap Bs Cd\"");
    }

    @Test
    public void parse_shouldThrowException_withWrongOperator() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "x", "3p", "4s", "10d"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT & VERIFY
        assertThatThrownBy(sut::parse)
                .isInstanceOf(Exception.class)
                .hasMessage("Malformed expression: operator x is not supported.");
    }

    @Test
    public void parse_shouldThrowException_withMul_withTwoOldPound() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "*", "3p", "4s", "10d"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT & VERIFY
        assertThatThrownBy(sut::parse)
                .isInstanceOf(Exception.class)
                .hasMessage("Raw operation is malformed for operator / and *. It required to be in this form \"Xp Ys Zd [*|/] K\"");
    }

    @Test
    public void parse_shouldThrowException_withSum_withOldPoundAndInt() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "*", "10"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT & VERIFY
        assertThatThrownBy(sut::parse)
                .isInstanceOf(Exception.class)
                .hasMessage("Raw operation is malformed for operator / and *. It required to be in this form \"Xp Ys Zd [*|/] K\"");
    }
}
