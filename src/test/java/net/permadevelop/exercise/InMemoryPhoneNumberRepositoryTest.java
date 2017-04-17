package net.permadevelop.exercise;

import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.contains;

public class InMemoryPhoneNumberRepositoryTest {

    @Test
    public void addedNumberExists() {
        PhoneNumberRepository repository = new InMemoryPhoneNumberRepository();
        PhoneNumber phoneNumber = new PhoneNumber("351", "210000000");

        repository.add(phoneNumber);
        repository.add(new PhoneNumber("351", "960000000"));

        assertThat(repository.getAll(), hasItem(phoneNumber));
    }
}