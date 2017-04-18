package net.permadevelop.exercise;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PhoneNumberParserTest {
    private static final String FULL_VALID_NUMBER = "351961034567";
    private PhoneNumberParser parser;

    @Before
    public void setUp() {
        parser = new PhoneNumberParser(Collections.emptyList());
    }

    @Test
    public void parseFull12DigitsNumber() {
        assertThat(parser.parse(FULL_VALID_NUMBER).get().complete(),
                is(FULL_VALID_NUMBER));
    }

    @Test
    public void parse7DigitsNumber() {
        String number = "1234567";

        assertThat(parser.parse(number).get().complete(),
                is(number));
    }

    @Test
    public void parseSpecialNumber() {
        String number = "123";

        assertThat(parser.parse(number).get().complete(), is(number));
    }

    @Test
    public void spacesAreRemoved() {
        final String number = " 351  96 12 30 567 ";

        assertThat(parser.parse(number).get().complete().matches(".*\\s+.*"),
                is(false));
    }

    @Test
    public void leadingZerosAreRemoved() {
        final String number = "351961200567";

        assertThat(parser.parse("00" + number).get().complete(), is(number));
    }

    @Test
    public void numberWithSymbolIsNotParsed() {
        String number = "1234*567";

        assertThat(parser.parse(number).isPresent(), is(false));
    }

    @Test
    public void numberWithLettersIsNotParsed() {
        String number = "12a3456b7";
        assertThat(parser.parse(number).isPresent(), is(false));
    }

    @Test
    public void numberWithLessThan7DigitsIsNotParsed() {
        String number = "123456";
        assertThat(parser.parse(number).isPresent(), is(false));
    }

    @Test
    public void numberWithMoreThan12DigitsIsNotParsed() {
        String number = "1234567890123";
        assertThat(parser.parse(number).isPresent(), is(false));
    }

    @Test
    public void parseNumberWithPlusAtBeginning() {
        String number = "+" + FULL_VALID_NUMBER;

        assertThat(parser.parse(number).get().complete(), is(FULL_VALID_NUMBER));
    }

    @Test
    public void numberWithPlusAndSpaceAfterIsNotParsed() {
        String number = "+ " + FULL_VALID_NUMBER;

        assertThat(parser.parse(number).isPresent(), is(false));
    }

    @Test
    public void numberWithPlusAndZerosAfterIsNotParsed() {
        String number = "+00" + "123456789";

        assertThat(parser.parse(number).isPresent(), is(false));
    }
}