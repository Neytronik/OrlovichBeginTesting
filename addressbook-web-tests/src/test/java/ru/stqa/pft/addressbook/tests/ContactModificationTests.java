package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.сontact().all().size() == 0) {
            app.сontact().create(new ContactData().withFirstName("Petr").withMiddleName("Petrovich").withLastName("Petrov")
                    .withNikName("Prist").withAddress("Saratov").withHomeTelephone("98765432").withMobile("123456789"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.сontact().all();
        ContactData modifiedContact = before.iterator().next();

        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Petro")
                .withMiddleName("Vasilyevich").withLastName("Petrovskiy").withNikName("Prist")
                .withAddress("Moscow").withHomeTelephone("123456").withMobile("987654321");
        app.сontact().modify(contact);
        assertThat(app.сontact().count(), equalTo(before.size()));
        Contacts after = app.сontact().all();

        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }


}
