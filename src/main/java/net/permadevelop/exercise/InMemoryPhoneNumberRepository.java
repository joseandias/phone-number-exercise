package net.permadevelop.exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InMemoryPhoneNumberRepository implements PhoneNumberRepository {
    private List<PhoneNumber> storage = new ArrayList<>();

    @Override
    public void add(PhoneNumber phoneNumber) {
        storage.add(phoneNumber);
    }

    @Override
    public Collection<PhoneNumber> getAll() {
        return Collections.unmodifiableCollection(storage);
    }
}
