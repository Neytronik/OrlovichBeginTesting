package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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


    public void deleteSelected() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
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

    public void create(ContactData contact) {
        initContact();
        fillContactInformation(contact);
        submitCreateContact();
        contactCache = null;
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        int i = 2;
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstName = getContextField(By.xpath("//*[@id=\"maintable\"]/tbody/tr[" + i + "]/td[3]"));
            String lastName = getContextField(By.xpath("//*[@id=\"maintable\"]/tbody/tr[" + i + "]/td[2]"));
            String address = getContextField(By.xpath("//*[@id=\"maintable\"]/tbody/tr[" + i + "]/td[4]"));
            String allPhones = getContextField(By.xpath("//*[@id=\"maintable\"]/tbody/tr[" + i + "]/td[6]"));
            String[] phones = allPhones.split("\n");
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
                    .withHomeTelephone(phones[0]).withMobile(phones[1]).withAddress(address);
            contactCache.add(contact);
            i++;
        }
        return new Contacts(contactCache);
    }

    public String getContextField(By locator) {
        return wd.findElement(locator).getText();
    }

    public void modify(ContactData contact) {
        editContactById(contact.getId());
        modificationContactInformation(contact);
        updateContact();
        contactCache = null;
        returnToHomePage();
    }

    private void editContactById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void delete(ContactData contact) {
        selectById(contact.getId());
        deleteSelected();
        applyDialog();
        contactCache = null;
    }

    private void selectById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public ContactData infoFromEditForm(ContactData contact) {
        editContactById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        wd.navigate().back();

        return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
                .withHomeTelephone(home).withMobile(mobile).withAddress(address);
    }
}
