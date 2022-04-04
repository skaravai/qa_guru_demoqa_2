package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1980";
    }

    @Test
    void fillFormTest() {
        String name = "Alex Egorov";
        String email = "alex@egorov.com";
        String currentAddress = "Street 1";
        String permanentAddress = "Another address 2";

        open("/text-box");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();


        //Asserts
        $("[id=output]").shouldHave(text(name),text(email),
                text(currentAddress), text(permanentAddress));

        $("[id=output] [id=name]").shouldHave(text(name));
        $("[id=output]").$("[id=name]").shouldHave(text(name));
        $("[id=name]").shouldHave(text(name));

        $("[id=permanentAddress]").shouldHave(text("PermanentAddress :Another address 2")); //wrong
        $("p[id=permanentAddress]").shouldHave(text("PermanentAddress :Another address 2")); //wrong
        $("[id=permanentAddress]", 1).shouldHave(text("PermanentAddress :Another address 2")); //wrong

    }
}
