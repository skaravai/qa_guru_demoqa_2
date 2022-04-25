   package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import java.io.File;

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

        Faker faker = new Faker();
        File file = new File("src/test/resources/img/image.png");

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Male",
                mobileNumber = faker.number().digits(10),
                currentAddress = faker.address().fullAddress(),
                month = "October",
                year = "1993",
                subject = "English";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(mobileNumber)
                .setDateOfBirth(month, year, "28")
                .setSubject(subject)
                .setHobbie()
                .uploadFile(file)
                .setCurrentAddress(currentAddress)
                .setStateAndCity("NCR", "Delhi")
                .clickSubmit();

        //Assertions
        registrationFormPage.checkFormOpened()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender);

    }
}
