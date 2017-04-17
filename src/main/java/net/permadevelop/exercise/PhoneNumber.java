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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return areaCode != null ? areaCode.equals(that.areaCode) : that.areaCode == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (areaCode != null ? areaCode.hashCode() : 0);
        return result;
    }
}
