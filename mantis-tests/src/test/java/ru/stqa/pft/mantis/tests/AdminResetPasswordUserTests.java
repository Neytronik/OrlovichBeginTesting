package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.User;

import java.util.List;

public class AdminResetPasswordUserTests extends TestBase {

    @Test
    public void resetPasswordTest() {
        app.mail().start();
        app.admin().login("administrator", "root");
        app.navigate().goTo(By.linkText("Manage Users"));
        User user = app.dataBase().allUser().iterator().next();
        String email = user.getEmail();
        app.navigate().goTo(By.linkText(user.getUserName()));
        app.getDriver().findElement(By.xpath("/html/body/div[4]/form[1]/input[3]")).click();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        String newPas = "pass";
        app.admin().finish(confirmationLink, newPas);
        System.out.println("");
        app.mail().stop();
        app.admin().login(user.getUserName(),newPas);

    }
}
