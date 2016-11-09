package training.ua;

public enum Month {

    JANUARY(31, 1), FEBRUARY(28, 2), MARCH(31, 3), APRIL(30, 4), MAY(31, 5),
    JUNE(30, 6), JULY(31, 7), AUGUST(31, 8), SEPTEMBER(30, 9), OCTOBER(31, 10),
    NOVEMBER(30, 11), DECEMBER(31, 12);

    private int daysInMonth;
    private int serialNumber;
    private int daysBeforeMonth;

    Month(int daysInMonth, int serialNumber) {
        this.daysInMonth = daysInMonth;
        this.serialNumber = serialNumber;
    }

    public int getDaysInMonth() {
        return daysInMonth;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getDaysBeforeMonth() {
        if (daysBeforeMonth == 0) {
            Month[] months = Month.values();
            for (int i = 0; i < serialNumber - 1; i++) {
                if (months[i].getSerialNumber() < serialNumber) {
                    daysBeforeMonth += months[i].daysInMonth;
                }
            }
        }
        return daysBeforeMonth;
    }
}
