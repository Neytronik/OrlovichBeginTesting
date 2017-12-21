package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContact();
        app.getContactHelper().fillContactInformation(new ContactData("Petr", "Petrovich", "Petrov", "Prist", "Saratov", "98765432", "123456789"));
        app.getContactHelper().createContact();
    }

}