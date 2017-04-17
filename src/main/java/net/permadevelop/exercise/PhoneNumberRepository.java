package net.permadevelop.exercise;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface PhoneNumberRepository {
    void add(PhoneNumber phoneNumber);

    Collection<PhoneNumber> getAll();

    List<Map.Entry<String, Long>> getAllByArea();
}
