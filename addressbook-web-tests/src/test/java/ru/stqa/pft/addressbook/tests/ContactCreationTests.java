package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        List<ContactData> before = app.сontact().list();
        ContactData contact = new ContactData().withFirstName("Petr").withMiddleName("Petrovich").withLastName("Petrov")
                .withNikName("Prist").withAddress("Saratov").withHomeTelephone("98765432").withMobile("123456789");
        app.сontact().create(contact);
        app.goTo().homePage();
        List<ContactData> after = app.сontact().list();
        Assert.assertEquals(after.size(),before.size()+1);
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }

}
