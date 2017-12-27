package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.сontact().all();
        ContactData contact = new ContactData().withFirstName("Petr").withMiddleName("Petrovich").withLastName("Petrov")
                .withNikName("Prist").withAddress("Saratov").withHomeTelephone("98765432").withMobile("123456789");
        app.сontact().create(contact);
        app.goTo().homePage();
        assertThat(app.сontact().count(), equalTo(before.size() + 1));
        Contacts after = app.сontact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }

    @Test
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.сontact().all();
        ContactData contact = new ContactData().withFirstName("Petr'").withMiddleName("Petrovich").withLastName("Petrov")
                .withNikName("Prist").withAddress("Saratov").withHomeTelephone("98765432").withMobile("123456789");
        app.сontact().create(contact);
        app.goTo().homePage();
        assertThat(app.сontact().count(), equalTo(before.size()));
        Contacts after = app.сontact().all();

        assertThat(after, equalTo(before));

    }
}
