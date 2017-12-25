package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactInformation(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNikName());
        typeDefault(By.name("title"));
        type(By.name("company"), "Corp");
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomeTelephone());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), "12");
        type(By.name("fax"), "123");
        typeDefault(By.name("email2"));
        typeDefault(By.name("email3"));
        typeDefault(By.name("homepage"));
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).click();
        }
        typeDefault(By.name("byear"));
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).click();
        }
        typeDefault(By.name("ayear"));
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).click();
        }
        typeDefault(By.name("address2"));
        typeDefault(By.name("phone2"));
        typeDefault(By.name("notes"));
    }

    public void submitCreateContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void initContact() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
//        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[1]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void editContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void modificationContactInformation(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNikName());
        typeDefault(By.name("title"));
        type(By.name("company"), "Corp");
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomeTelephone());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), "12");
        type(By.name("fax"), "123");
    }

    public void createContact(ContactData contact) {
        initContact();
        fillContactInformation(contact);
        submitCreateContact();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        int i = 2;
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstName = getContextField(By.xpath("//*[@id=\"maintable\"]/tbody/tr[" + i + "]/td[3]"));
            String lastName = getContextField(By.xpath("//*[@id=\"maintable\"]/tbody/tr[" + i + "]/td[2]"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, firstName, null, lastName, null, null, null, null);
            contacts.add(contact);
            i++;
        }
        return contacts;
    }

    public String getContextField(By locator) {
        return wd.findElement(locator).getText();
    }
}
