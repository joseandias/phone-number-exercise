package net.permadevelop.exercise;

public class PhoneNumber {
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

    public boolean hasAreaCode() {
        return !areaCode.equals(NO_AREA_CODE);
    }

    public String areaCode() {
        return areaCode;
    }

    public String complete() {
        return this.hasAreaCode() ? this.areaCode() + number : number;
    }

    public String localPart() {
        return number;
    }
}
