package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

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
    public void ContactDeletionTests() {

        Contacts before = app.сontact().all();
        ContactData deletedContact = before.iterator().next();
        app.сontact().delete(deletedContact);
        app.goTo().homePage();
        assertThat(app.сontact().count(), equalTo(before.size()-1));
        Contacts after = app.сontact().all();

        assertThat(after, equalTo(before.withOut(deletedContact)));
    }

}
