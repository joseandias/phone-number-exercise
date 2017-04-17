package net.permadevelop.exercise.acceptance;

import net.permadevelop.exercise.App;
import net.permadevelop.exercise.PhoneNumber;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {

    @Test
    @Ignore
    public void presentsFirstNumberFromPhoneNumbersFile() {
        App app = new App("phone_numbers.txt");

        Collection<PhoneNumber> phoneNumbers = app.phoneNumbers();

        assertThat(phoneNumbers.iterator().next().complete(), is("351960000000"));
    }
}
