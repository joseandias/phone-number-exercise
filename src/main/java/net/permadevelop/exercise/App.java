package net.permadevelop.exercise;

import java.util.Collection;
import java.util.stream.Collectors;

public class App {
    private static final String AREA_CODES_FILENAME = "area_codes.txt";
    private final PhoneNumberParser parser;
    private final PhoneNumberRepository repository = new InMemoryPhoneNumberRepository();

    public App(String numbersFileName) {
        Collection<String> areaCodes = new MyFileReader().linesFor(AREA_CODES_FILENAME);
        parser = new PhoneNumberParser(areaCodes);
        new MyFileReader().linesFor(numbersFileName).stream()
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
