package net.permadevelop.exercise;

import java.util.Optional;

public class PhoneNumberParser {
    public Optional<PhoneNumber> parse(String number) {
        String numberWithoutSymbol = removeLeadingSymbol(number);
        String numberWithoutWhiteSpaces = removeWhiteSpaces(numberWithoutSymbol);
        if (!numberWithoutWhiteSpaces.matches("[0-9]{7,12}")) {
            return Optional.empty();
        }
        PhoneNumber phoneNumber = new PhoneNumber(numberWithoutWhiteSpaces);
        return Optional.of(phoneNumber);
    }

    private String removeWhiteSpaces(String number) {
        return number.replaceAll("\\s", "");
    }

    private String removeLeadingSymbol(String number) {
        return number.startsWith("+") ? number.substring(1) : number;
    }
}
