package net.permadevelop.exercise.acceptance;

import net.permadevelop.exercise.App;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {

    @Test
    public void presentsOneLineFromPhoneNumbersFile() {
        App app = new App("phone_numbers.txt");

        String phoneNumber = app.phoneNumbers();

        assertThat(phoneNumber, is("351960000000"));
    }
}
