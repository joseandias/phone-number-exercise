package net.permadevelop.exercise;

import java.util.Collection;
import java.util.Optional;

class PhoneNumberParser {
    private Collection<String> areaCodes;

    PhoneNumberParser(Collection<String> areaCodes) {
        this.areaCodes = areaCodes;
    }

    Optional<PhoneNumber> parse(String number) {
        if (!respectsLeadingSymbolRules(number)) {
            return Optional.empty();
        }

        number = clean(number);

        if (!isValid(number)) {
            return Optional.empty();
        }

        return Optional.of(buildWithAreaCode(number));
    }

    private PhoneNumber buildWithAreaCode(String number) {
        if (number.length() > 9) {
            String potentialAreaCode = number.substring(0, number.length() - 9);
            if (isAreaCode(potentialAreaCode)) {
                return new PhoneNumber(
                        potentialAreaCode,
                        number.substring(number.length() - 9)
                );
            }
        }
        return new PhoneNumber(number);
    }

    private boolean isAreaCode(String code) {
        return areaCodes.contains(code);
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
