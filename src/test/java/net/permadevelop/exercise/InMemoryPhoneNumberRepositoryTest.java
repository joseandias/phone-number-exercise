package net.permadevelop.exercise;

import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class InMemoryPhoneNumberRepositoryTest {

    private PhoneNumberRepository repository;
    private static final PhoneNumber PHONE_NUMBER = new PhoneNumber("351", "210000000");

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryPhoneNumberRepository();

        repository.add(PHONE_NUMBER);
        repository.add(new PhoneNumber("800", "123456789"));
        repository.add(new PhoneNumber("351", "960000000"));
        repository.add(new PhoneNumber("20", "123456789"));
    }

    @Test
    public void addedNumberExists() {
        assertThat(repository.getAll(), hasItem(PHONE_NUMBER));
    }

    @Test
    public void getByAreaCodeContainsAllNumbersGroupedByAreaCode() {
        assertThat(repository.getAllByArea(), hasItem(new AbstractMap.SimpleEntry<>("351", 2L)));
    }

    @Test
    public void getByAreaCodeContainsAllNumbersSortedByAreaCode() {
        assertThat(repository.getAllByArea(), contains(
                new AbstractMap.SimpleEntry<>("20", 1L),
                new AbstractMap.SimpleEntry<>("351", 2L),
                new AbstractMap.SimpleEntry<>("800", 1L)
        ));
    }


}