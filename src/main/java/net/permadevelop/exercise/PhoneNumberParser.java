package net.permadevelop.exercise;

import java.util.Optional;

class PhoneNumberParser {
    Optional<PhoneNumber> parse(String number) {
        if (!respectsLeadingSymbolRules(number)) {
            return Optional.empty();
        }

        number = clean(number);

        if (!isValid(number)) {
            return Optional.empty();
        }
        return Optional.of(new PhoneNumber(number));
    }

    private boolean respectsLeadingSymbolRules(String number) {
        boolean isValid = true;
        if (number.startsWith("+")) {
            isValid = !number.matches("^\\+ {1}.*")
                    && !number.matches("^\\+00.*");
        }
        return isValid;
    }

    private boolean isValid(String number) {
        return number.matches("^[0-9]{7,12}") ||
                number.matches("^[0-9]{3}");
    }

    private String clean(String number) {
        return new FluentString(number)
                .cleanLeadingSymbol()
                .cleanWhiteSpaces()
                .cleanLeadingZeros()
                .toString();
    }

    private static class FluentString {
        private String currentString;

        FluentString(String initialString) {
            this.currentString = initialString;
        }

        private FluentString cleanLeadingZeros() {
            currentString = currentString.replaceAll("^00", "");
            return this;
        }

        private FluentString cleanWhiteSpaces() {
            currentString = currentString.replaceAll("\\s", "");
            return this;
        }

        private FluentString cleanLeadingSymbol() {
            currentString = currentString.startsWith("+") ?
                    currentString.substring(1) : currentString;
            return this;
        }

        @Override
        public String toString() {
            return currentString;
        }
    }
}
