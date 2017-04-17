package net.permadevelop.exercise.acceptance;

import net.permadevelop.exercise.App;
import net.permadevelop.exercise.PhoneNumber;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class AppTest {

    @Test
    public void presentsNumbersFromPhoneNumbersFile() {
        App app = new App("phone_numbers.txt");

        Collection<String> phoneNumbers = app.phoneNumbers();

        assertThat(phoneNumbers, hasItem("351960000000"));
        assertThat(phoneNumbers, hasItem("351961111111"));
        assertThat(phoneNumbers, hasItem("351210000000"));
        assertThat(phoneNumbers, hasItem("244910000000"));
        assertThat(phoneNumbers, not(hasItem("35112")));
    }
}
