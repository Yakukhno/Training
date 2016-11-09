package training.ua;

public interface INote {

    String getFirstName();
    void setFirstName(String firstName);
    public String getLastName();
    public void setLastName(String lastName);
    public String getMiddleName();
    public void setMiddleName(String middleName);
    public int getPhoneNumber();
    public void setPhoneNumber(int phoneNumber);
    Date getBirthday();
    void setBirthday(Date birthday);

}
