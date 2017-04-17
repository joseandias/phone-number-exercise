package net.permadevelop.exercise;

import java.util.Collection;
import java.util.stream.Collectors;

public class App {
    private final PhoneNumberParser parser = new PhoneNumberParser();
    private final PhoneNumberRepository repository = new InMemoryPhoneNumberRepository();

    public App(String fileName) {
        new MyFileReader().linesFor(fileName).stream()
                .map(parser::parse)
                .forEach(number -> number.ifPresent(repository::add));
    }

    public Collection<String> phoneNumbers() {
        return repository.getAll().stream()
                .map(PhoneNumber::complete)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new App("phone_numbers.txt").phoneNumbers());
    }
}
