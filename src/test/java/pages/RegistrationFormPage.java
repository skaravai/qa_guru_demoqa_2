package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    //locators
    SelenideElement  firstNameInput = $("#firstName");

    //actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName (String name) {
        firstNameInput.setValue(name);

        return this;
    }

    public RegistrationFormPage setLastName (String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationFormPage setEmail (String email) {
        $("#userEmail").setValue(email);

        return this;
    }

    public RegistrationFormPage setPhone (String number) {
        $("#userNumber").setValue(number);

        return this;
    }
    public RegistrationFormPage setGender (String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationFormPage setDateOfBirth (String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day  + ":not(.react-datepicker__day--outside-month)").click();

        return this;
    }

    public RegistrationFormPage setSubject (String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbie () {
        $("#hobbiesWrapper").$(byText("Reading")).click();

        return this;
    }

    public RegistrationFormPage uploadFile (File file) {
        $("#uploadPicture").uploadFile(file);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String currentAddress){
        $("#currentAddress").setValue(currentAddress);

        return this;
    }

    public RegistrationFormPage setStateAndCity (String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    public RegistrationFormPage clickSubmit() {
        $("#submit").click();

        return this;
    }

    public RegistrationFormPage checkFormOpened() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }
    public RegistrationFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value ));

        return this;
    }

}
