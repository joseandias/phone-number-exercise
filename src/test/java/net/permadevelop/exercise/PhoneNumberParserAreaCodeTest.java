package net.permadevelop.exercise;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PhoneNumberParserAreaCodeTest {
    private PhoneNumberParser parser;

    @Before
    public void setUp() {
        Collection<String> areaCodes = Arrays.asList("351", "44", "998");
        parser = new PhoneNumberParser(areaCodes);
    }

    @Test
    public void numberWith12DigitsHasAreaCodeAndLocalPart() {
        String number = "351961034567";

        Optional<PhoneNumber> phoneNumber = parser.parse(number);

        assertThat(phoneNumber.get().complete(), is(number));
        assertThat(phoneNumber.get().hasAreaCode(), is(true));
        assertThat(phoneNumber.get().areaCode(), is("351"));
        assertThat(phoneNumber.get().localPart(), is("961034567"));
    }

    @Test
    public void numberWith11DigitsHasAreaCodeAndLocalPart() {
        String number = "44961034567";

        Optional<PhoneNumber> phoneNumber = parser.parse(number);

        assertThat(phoneNumber.get().complete(), is(number));
        assertThat(phoneNumber.get().hasAreaCode(), is(true));
        assertThat(phoneNumber.get().areaCode(), is("44"));
        assertThat(phoneNumber.get().localPart(), is("961034567"));
    }

    @Test
    public void numberWith9DigitsHasNoAreaCode() {
        String number = "123456789";

        Optional<PhoneNumber> phoneNumber = parser.parse(number);

        assertThat(phoneNumber.get().complete(), is(number));
        assertThat(phoneNumber.get().hasAreaCode(), is(false));
    }

    @Test
    public void invalidAreaCodeIsParsedAsFullLocalNumber() {
        String number = "999123456789";

        Optional<PhoneNumber> phoneNumber = parser.parse(number);

        assertThat(phoneNumber.get().hasAreaCode(), is(false));
        assertThat(phoneNumber.get().localPart(), is(number));
    }

}
