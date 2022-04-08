package guru.qa.homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1450";
    }

    @Test
    void fillFormTest() {
        String name = "Sergei";
        String last_name = "Karavai";
        String email = "testemail@gmail.com";
        String mobileNumber = "1232020327";
        String subject = "English";
        String year = "1995";
        String month = "October";
        String day = "26";
        String currentAddress = "Lenina 50";
        File file = new File("src/test/java/guru/qa/resources/image.png");

        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(last_name);
        $("#userEmail").setValue(email);
//        $(byText("Male")).click();
//        $("#userNumber").setValue(mobileNumber);
//
//        // setting date of birth
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption(month);
//        $(".react-datepicker__year-select").selectOption(year);
//        $(".react-datepicker__day--004").click();
//
//
//        $("#subjectsInput").setValue(subject).pressEnter();
//        $(byText("Reading")).click();
//        $("#uploadPicture").uploadFile(file);
//        $("#currentAddress").setValue(currentAddress);
//
//
//
//        $(".css-1hwfws3").setValue("Haryana").pressEnter();
//        $(".css-1g6gooi").setValue("Karnal").pressEnter();
//
//        $("submit").click();

        //Assertions
        $("#firstName").shouldHave(text(name));
        $("#last_name").shouldHave(text(last_name));
        $("#lastName").setValue(last_name);


    }

}
