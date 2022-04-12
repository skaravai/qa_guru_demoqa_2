package pages;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    //locators

    //actions
    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public void setFirstName (String name) {
        $("#firstName").setValue(name);
    }

    public void setLastName (String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void setEmail (String email) {
        $("#userEmail").setValue(email);
    }

    public void setPhone (String number) {
        $("#userNumber").setValue(number);
    }
    public void setGender (String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    public void setDateOfBirth (String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--0" + day  + ":not(.react-datepicker__day--outside-month)").click();
    }

    public void setSubject (String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    public void setHobbie () {
        $("#hobbiesWrapper").$(byText("Reading")).click();
    }

    public void uploadFile (File file) {
        $("#uploadPicture").uploadFile(file);
    }

    public void setCurrentAddress(String currentAddress){
        $("#currentAddress").setValue(currentAddress);
    }

    public void setStateAndCity (String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    public void clickSubmit() {
        $("#submit").click();
    }

    public void checkFormOpened() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
    public void checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value ));
    }


}
