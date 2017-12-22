package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactInformation(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("middlename"),contactData.getMiddleName());
        type(By.name("lastname"),contactData.getLastName());
        type(By.name("nickname"),contactData.getNikName());
        typeDefault(By.name("title"));
        type(By.name("company"),"Corp");
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getHomeTelephone());
        type(By.name("mobile"),contactData.getMobile());
        type(By.name("work"),"12");
        type(By.name("fax"),"123");
        type(By.name("fax"),"123");

        typeDefault(By.name("email"));
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

    public void createContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void initContact() {
        click(By.linkText("add new"));
    }

    public void selectContact() {
        click(By.id("8"));
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
        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("middlename"),contactData.getMiddleName());
        type(By.name("lastname"),contactData.getLastName());
        type(By.name("nickname"),contactData.getNikName());
        typeDefault(By.name("title"));
        type(By.name("company"),"Corp");
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getHomeTelephone());
        type(By.name("mobile"),contactData.getMobile());
        type(By.name("work"),"12");
        type(By.name("fax"),"123");
    }
}
