   package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectsTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
    //    Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1250";
    }

    @Test
    void fillFormTest() {


        File file = new File("src/test/resources/img/image.png");

        registrationFormPage.openPage();
        registrationFormPage.setFirstName("Sergei");
        registrationFormPage.setLastName("Karavai");
        registrationFormPage.setEmail("testemail@gmail.com");
        registrationFormPage.setGender("Male");
        registrationFormPage.setPhone("1232020327");
        registrationFormPage.setDateOfBirth("October", "1993", "28");
        registrationFormPage.setSubject("English");
        registrationFormPage.setHobbie();
        registrationFormPage.uploadFile(file);
        registrationFormPage.setCurrentAddress("Lenina 50");
        registrationFormPage.setStateAndCity("NCR", "Delhi");
        registrationFormPage.clickSubmit();

        //Assertions
        registrationFormPage.checkFormOpened();
        registrationFormPage.checkResult("Student Name", "Sergei Karavai");
        registrationFormPage.checkResult("Student Email", "testemail@gmail.com");
        registrationFormPage.checkResult("Gender", "Male");

    }
}
