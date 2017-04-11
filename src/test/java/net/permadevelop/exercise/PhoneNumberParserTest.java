package net.permadevelop.exercise;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PhoneNumberParserTest {
    public static final String FULL_VALID_NUMBER = "351960000000";
    private PhoneNumberParser parser;

    @Before
    public void setUp() {
        parser = new PhoneNumberParser();
    }

    @Test
    public void parseFullNumber() {
        assertThat(parser.parse(FULL_VALID_NUMBER).get().complete(),
                is(FULL_VALID_NUMBER));
    }

    @Test
    public void parseNumberWithMultipleSpaces() {
        final String number = " 351  96 00 00 000 ";

        assertThat(parser.parse(number).get().complete().matches(".*\\s+.*"),
                is(false));
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
    @Ignore
    public void numberWithPlusAndSpaceAfterIsNotParsed() {
        String number = "+ " + FULL_VALID_NUMBER;

        assertThat(parser.parse(number).isPresent(), is(false));
    }
}