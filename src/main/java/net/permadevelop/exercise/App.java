package net.permadevelop.exercise;

import java.util.Collection;

public class App {
    private final Collection<String> inputLines;

    public App(String fileName) {
        inputLines = new MyFileReader().linesFor(fileName);

    }

    public String phoneNumbers() {
        return inputLines.iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(new App("phone_numbers.txt").phoneNumbers());
    }
}
