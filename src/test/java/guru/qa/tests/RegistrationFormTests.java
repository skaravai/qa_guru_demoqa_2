package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void setUp() {
    //    Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1250";
    }

    @Test
    void fillFormTest() {
        String name = "Sergei";
        String last_name = "Karavai";
        String email = "testemail@gmail.com";
        String mobileNumber = "1232020327";
        String subject = "English";
        String currentAddress = "Lenina 50";
        File file = new File("src/test/resources/img/image.png");

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("#firstName").setValue(name);
        $("#lastName").setValue(last_name);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(mobileNumber);

        // setting date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        //$("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        //Assertions
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Sergei"), text("Karavai"), text("testemail@gmail.com "));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Sergei Karavai"));

    }
}
