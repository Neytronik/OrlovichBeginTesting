package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

public class RegistrationTests extends TestBase {


    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException{
        long now = System.currentTimeMillis();
        String email = String.format("user%s@localhost.localdomain",now);
        String userName = String.format("user%s",now);
        String password = "password";
        app.registration().start(userName, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);

        Assert.assertTrue(app.newSession().login(userName, password));
    }

    @AfterMethod(alwaysRun = true )
    public void stopMailServer() {
        app.mail().stop();
    }
}
