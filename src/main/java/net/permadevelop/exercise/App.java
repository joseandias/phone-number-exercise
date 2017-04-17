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

    public Collection<String> areaOccurrences() {
        return repository.getAllByArea().stream()
                .map(area -> area.getKey() + ":" + area.getValue())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new App("phone_numbers.txt").areaOccurrences()
                .forEach(System.out::println);
    }
}
