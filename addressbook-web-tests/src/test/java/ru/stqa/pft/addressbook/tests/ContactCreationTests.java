package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Set<ContactData> before = app.сontact().all();
        ContactData contact = new ContactData().withFirstName("Petr").withMiddleName("Petrovich").withLastName("Petrov")
                .withNikName("Prist").withAddress("Saratov").withHomeTelephone("98765432").withMobile("123456789");
        app.сontact().create(contact);
        app.goTo().homePage();
        Set<ContactData> after = app.сontact().all();
        Assert.assertEquals(after.size(),before.size()+1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());

        before.add(contact);

        Assert.assertEquals(before,after);

    }

}
