package training.ua;

import java.util.Calendar;

public class Note implements INote, Cloneable {

    private String firstName;
    private String lastName;
    private String middleName;
    private int phoneNumber;
    private Date birthday;

    public Note(String firstName, String lastName, String middleName,
                int phoneNumber, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    @Invoke
    public int getDaysToBirthday() {
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        int birthdayDay = birthday.getMonth().getDaysBeforeMonth()
                + birthday.getDay();

        return (birthdayDay > currentDay)
                ? (birthdayDay - currentDay)
                : (365 + birthdayDay - currentDay);
    }

    @Invoke
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Invoke
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Invoke
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Note note = (Note) o;

        if (!firstName.equals(note.firstName)
                || !lastName.equals(note.lastName)
                || !middleName.equals(note.middleName)) {
            return false;
        }
        return birthday != null ? birthday.equals(note.birthday) : note.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note in notebook" + '\n' +
                "firstName = " + firstName + '\n' +
                "lastName = " + lastName + '\n' +
                "middleName = " + middleName + '\n' +
                "phoneNumber = " + phoneNumber + '\n' +
                "birthday = " + birthday;
    }
}
