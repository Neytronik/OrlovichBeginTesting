package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class AdministratorHelper extends HelperBase {
    public AdministratorHelper(ApplicationManager app) {
    super(app);
    }


    public void login(String login, String password) {

        type(By.name("username"), login);
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));

    }
    public void finish(String confirmationLink, String password) {

        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));

    }
}
