package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactProfileInfoTests extends TestBase {

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
        String contactInfoFromViewForm = app.сontact().infoFromProfileForm(contact);
        app.goTo().homePage();

        String contactInfoFromEditForm = mergeContactInfo(app.сontact().infoFromEditForm(contact));
        System.out.println(cleaned(contactInfoFromViewForm));

        assertThat(cleaned(contactInfoFromViewForm),equalTo(contactInfoFromEditForm));
//        assertThat(contact.getAddress(),equalTo(cleaned(contactInfoFromEditForm.getAddress())));
//        assertThat(contact.getFirstName(),equalTo(cleaned(contactInfoFromEditForm.getFirstName())));


    }

    private String mergeContactInfo(ContactData c) {
        return Arrays.asList(c.getFirstName(),c.getMiddleName(),c.getLastName(),c.getNikName(),c.getTitle(),c.getCompany()
                ,c.getAddress(),"H:"+c.getHomeTelephone(),"M:"+c.getMobile(),"W:"+c.getWorkPhone(),"F:"+c.getFax(),c.getAllEmail()
                ,"Homepage:" + c.getHomepage(),"Birthday"+c.getBirthday(),"Anniversary"+c.getAnniversary(),c.getAddress2(),"P:"+c.getPhone2()+c.getNotes())
                .stream().filter((s -> !"".equals(s))).map(ContactProfileInfoTests::cleaned).collect(Collectors.joining(""));
    }


    public static String cleaned(String text) {
        if (text != null) {
            return text.replaceAll("\\s","").replaceAll("[-().]","");
        }
        return "";
    }
}
