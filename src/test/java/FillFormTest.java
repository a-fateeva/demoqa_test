import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTest {
    @Test
    public void firstTest() {
        open("https://demoqa.com/automation-practice-form");
        // First Name
        $("#firstName").setValue("Anastasia");

        // Last Name
        $("#lastName").setValue("Fateeva");

        // Email
        $("#userEmail").setValue("bebef@bebef.com");

        //Gender
        $("#genterWrapper").$(byText("Female")).click();

        // Mobile Number
        $("#userNumber").setValue("1234567890");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$("[value='4']").click();
        $("[value='4']").click();
        $(".react-datepicker__year-select").$("[value='2005']").click();
        $$(".react-datepicker__day").findBy(text("12")).click();

        // Subjects
        $("#subjectsInput").setValue("Maths").pressEnter();

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
        $(".table-responsive").shouldHave(text("Anastasia Fateeva"));
        $(".table-responsive").shouldHave(text("bebef@bebef.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("12 May,2005"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("исп.png"));
        $(".table-responsive").shouldHave(text("bebefiy dom, 56"));
        $(".table-responsive").shouldHave(text("NCR Noida"));


    }

}
