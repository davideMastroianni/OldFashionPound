package it.md.ofp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TestRawOperationParser {

    @Test
    public void parseLeftPound_shouldParseCorrectly_withCorrectRawPound() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "-", "3p", "4s", "10d"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT
        OldPound op_1 = sut.parseLeftPound();
        // VERIFY
        assertThat(op_1.getPounds()).isEqualTo(5);
        assertThat(op_1.getShillings()).isEqualTo(17);
        assertThat(op_1.getPence()).isEqualTo(8);
    }

    @Test
    public void parseRightPound_shouldParseCorrectly_withCorrectRawPound() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "-", "3p", "4s", "10d"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT
        OldPound op_1 = sut.parseRightPound();
        // VERIFY
        assertThat(op_1.getPounds()).isEqualTo(3);
        assertThat(op_1.getShillings()).isEqualTo(4);
        assertThat(op_1.getPence()).isEqualTo(10);
    }

    @Test
    public void rawStringToInt_shouldThrowException_withWrongOperationRawPound() {
        // SETUP
        String[] rawOperation = {"5p", "17s", "8d", "3p", "4s", "10d"};
        RawOperationParser sut = new RawOperationParser(rawOperation);
        // ACT & VERIFY
        assertThatThrownBy(() -> {
            sut.parseOperator();
        }).isInstanceOf(Exception.class).hasMessage("Malformed raw operation.");
    }
}
