package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nikName;
    private final String address;
    private final String homeTelephone;
    private final String mobile;

    public ContactData(int id, String firstName, String middleName, String lastName, String nikName, String address, String homeTelephone, String mobile) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nikName = nikName;

        this.address = address;
        this.homeTelephone = homeTelephone;
        this.mobile = mobile;
    }

    public ContactData(String firstName, String middleName, String lastName, String nikName, String address, String homeTelephone, String mobile) {
        this.id = Integer.MAX_VALUE;

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

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

}
