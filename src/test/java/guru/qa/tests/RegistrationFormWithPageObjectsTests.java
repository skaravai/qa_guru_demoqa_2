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
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1250";
    }

    @Test
    void fillFormTest() {

        File file = new File("src/test/resources/img/image.png");

        registrationFormPage.openPage()
                .setFirstName("Sergei")
                .setLastName("Karavai")
                .setEmail("testemail@gmail.com")
                .setGender("Male")
                .setPhone("1232020327")
                .setDateOfBirth("October", "1993", "28")
                .setSubject("English")
                .setHobbie()
                .uploadFile(file)
                .setCurrentAddress("Lenina 50")
                .setStateAndCity("NCR", "Delhi")
                .clickSubmit();

        //Assertions
        registrationFormPage.checkFormOpened()
                .checkResult("Student Name", "Sergei Karavai")
                .checkResult("Student Email", "testemail@gmail.com")
                .checkResult("Gender", "Male");

    }
}
