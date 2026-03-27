import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class NegativeTest {
    @Test
    public void thirdTest() {
        open("https://demoqa.com/automation-practice-form");

        // Email
        $("#userEmail").setValue("@b");

        // Mobile Number
        $("#userNumber").setValue("gdrgrd");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$("[value='4']").click();
        $("[value='4']").click();
        $(".react-datepicker__year-select").$("[value='2005']").click();
        $$(".react-datepicker__day").findBy(text("12")).click();

        // Subjects
        $("#subjectsInput").setValue("!");

        //Hobbies
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Picture
        $("#uploadPicture").uploadFromClasspath("исп.png");

        //Current adress
        $("#currentAddress").setValue("bebefiy dom, 56");

        //State and City
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        $("#submit").click();

        //Проверка
        $(".modal-content").shouldNotBe(visible);
        $("#firstName").shouldHave(cssClass("is-invalid"));
        $("#lastName").shouldHave(cssClass("is-invalid"));
        $("#userEmail").shouldHave(cssClass("is-invalid"));
        $("#userNumber").shouldHave(cssClass("is-invalid"));


    }
}
