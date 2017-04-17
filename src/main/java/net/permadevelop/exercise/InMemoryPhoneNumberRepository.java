package net.permadevelop.exercise;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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

    @Override
    public List<Map.Entry<String, Long>> getAllByArea() {
        Map<String, Long> areaCodes = storage.stream()
                .collect(Collectors.groupingBy(PhoneNumber::areaCode, Collectors.counting()));

        return areaCodes.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey())
                .collect(toList());
    }
}
