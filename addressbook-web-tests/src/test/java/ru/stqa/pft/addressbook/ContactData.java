package ru.stqa.pft.addressbook;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nikName;
    private final String address;
    private final String homeTelephone;
    private final String mobile;

    public ContactData(String firstName, String middleName, String lastName, String nikName, String address, String homeTelephone, String mobile) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nikName = nikName;
        this.address = address;
        this.homeTelephone = homeTelephone;
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNikName() {
        return nikName;
    }

    public String getAddress() {
        return address;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public String getMobile() {
        return mobile;
    }
}
