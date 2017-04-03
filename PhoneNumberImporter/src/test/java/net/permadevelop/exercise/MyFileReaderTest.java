package net.permadevelop.exercise;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class MyFileReaderTest {

    private static final String[] EXPECTED_NUMBERS = {
            "351960000000",
            "00351961111111",
            "351210000000",
            "35112",
            "244910000000"
    };

    @Test(expected = RuntimeException.class)
    public void linesForThrowsErrorWhenFileDoesNotExistReturnsAllLines() {
        new MyFileReader().linesFor("non_existing_file.txt");
    }

    @Test
    public void linesForReturnsAllLines() {
        Collection<String> fileLines = new MyFileReader().linesFor("phone_numbers.txt");

        assertThat(fileLines, containsInAnyOrder(EXPECTED_NUMBERS));
    }
}
