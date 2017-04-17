package net.permadevelop.exercise;

import java.util.Collection;

public interface PhoneNumberRepository {
    void add(PhoneNumber phoneNumber);

    Collection<PhoneNumber> getAll();
}
