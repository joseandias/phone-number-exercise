package net.permadevelop.exercise;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PhoneNumberParserAreaCodeTest {
    private PhoneNumberParser parser;

    @Before
    public void setUp() {
        parser = new PhoneNumberParser();
    }

    @Test
    public void areaCodeAndLocalPartAreCorrect() {
        String number = "351961034567";

        Optional<PhoneNumber> phoneNumber = parser.parse(number);

        assertThat(phoneNumber.get().complete(),
                is(number));
        assertThat(phoneNumber.get().hasAreaCode(),
                is(true));
        assertThat(phoneNumber.get().areaCode(),
                is("351"));
        assertThat(phoneNumber.get().localPart(),
                is("961034567"));
    }

    @Test
    public void numberWith9DigitsHasNoAreaCode() {
        String number = "123456789";

        Optional<PhoneNumber> phoneNumber = parser.parse(number);

        assertThat(phoneNumber.get().complete(),
                is(number));
        assertThat(phoneNumber.get().hasAreaCode(),
                is(false));
    }

}
