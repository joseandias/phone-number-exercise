package net.permadevelop.exercise.acceptance;

import net.permadevelop.exercise.App;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class AppTest {

    @Test
    public void presentsNumbersFromPhoneNumbersFile() {
        App app = new App("phone_numbers.txt");

        Collection<String> areaOccurrences = app.areaOccurrences();

        assertThat(areaOccurrences, contains("244:1", "351:3"));
    }
}
