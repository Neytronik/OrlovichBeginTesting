package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Petr", "Petrovich", "Petrov", "Prist", "Saratov", "98765432", "123456789"));
            app.getNavigationHelper().gotoHomePage();
        }
        app.getContactHelper().editContact();
        app.getContactHelper().modificationContactInformation(new ContactData("Petro", "Vasilyevich", "Petrov", "Prist", "Moscow", "98765432", "123456789"));
        app.getContactHelper().updateContact();
    }

}
