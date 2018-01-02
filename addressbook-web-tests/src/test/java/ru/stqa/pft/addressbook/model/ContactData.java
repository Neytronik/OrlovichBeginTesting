package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;
import java.util.Objects;

public class ContactData {
    private int id;
    @Expose
    private String firstName;
    @Expose
    private String middleName;
    @Expose
    private String lastName;
    private String nikName;
    @Expose
    private String company;
    @Expose
    private String title;
    @Expose
    private String address;
    @Expose
    private String homeTelephone;
    @Expose
    private String mobile;
    @Expose
    private String workPhone;
    @Expose
    private String fax;
    @Expose
    private String email;
    private String email2;
    private String email3;
    private String homepage;
    private String birthday;
    private String anniversary;
    private String address2;
    private String phone2;
    private String notes;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }


    public String getFax() {
        return fax;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public ContactData withsetBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public ContactData withAnniversary(String anniversary) {
        this.anniversary = anniversary;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }


    public String getPhone2() {
        return phone2;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }


    public String getWorkPhone() {
        return workPhone;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    private String allPhones;


    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withNikName(String nikName) {
        this.nikName = nikName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
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
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName);
    }

    public int getId() {
        return id;
    }


    public String getAllEmail() {
        return "petrpetrovpetrovich@corpwwwcorp0002цукац@sdvsdruwwwsdvsdru0003www003";
    }
}
