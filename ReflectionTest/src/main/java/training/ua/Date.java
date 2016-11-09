package training.ua;

public class Date {

    private int day;
    private Month month;
    private int year;

    public Date(int day, Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;

        if (day != date.day) return false;
        if (year != date.year) return false;
        return month == date.month;

    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month.hashCode();
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day = " + day +
                ", month = " + month +
                ", year = " + year +
                '}';
    }
}
