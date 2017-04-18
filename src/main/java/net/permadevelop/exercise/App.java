package net.permadevelop.exercise;

import java.io.File;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.lang.System.out;

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
        if (args.length == 1) {
            new App(args[0]).areaOccurrences()
                    .forEach(out::println);
        } else {
            showHelp();
        }
    }

    private static void showHelp() {
        String commandName = new File(App.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath())
                .getName();
        out.println("Usage: ");
        out.println("  " + commandName + " <input_file>");
        out.println("  e.g.: " + "java -jar " + commandName + " phone_numbers.txt");
    }
}
