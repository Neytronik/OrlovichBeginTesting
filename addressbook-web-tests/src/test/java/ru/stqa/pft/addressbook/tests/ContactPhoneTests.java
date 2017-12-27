package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

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
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.сontact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.сontact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(),equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAddress(),equalTo(cleaned(contactInfoFromEditForm.getAddress())));
        assertThat(contact.getFirstName(),equalTo(cleaned(contactInfoFromEditForm.getFirstName())));


    }

    private String mergePhones(ContactData contact) {
       return Arrays.asList(contact.getHomeTelephone(), contact.getMobile(),contact.getWorkPhone(),contact.getPhone2())
                .stream().filter((s -> !s.equals(""))).map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
    }

    public static String cleaned(String text) {
        return text.replaceAll("\\s","").replaceAll("[-()]","");
    }

}
