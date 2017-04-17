package net.permadevelop.exercise;

class PhoneNumber {
    private static final String NO_AREA_CODE = "0";

    private String number;
    private String areaCode = NO_AREA_CODE;

    PhoneNumber(String number) {
        this.number = number;
    }

    PhoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    boolean hasAreaCode() {
        return !areaCode.equals(NO_AREA_CODE);
    }

    String areaCode() {
        return areaCode;
    }

    String complete() {
        return this.hasAreaCode() ? this.areaCode() + number : number;
    }

    String localPart() {
        return number;
    }
}
