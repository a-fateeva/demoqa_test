import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class firstClass {
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
        $("#gender-radio-3").click();

        // Mobile Number
        $("#userNumber").setValue("1234567890");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value='4']").click();
        $(".react-datepicker__year-select").click();
        $("[value='2005']").click();
        $(".react-datepicker__day react-datepicker__day--012").click();

        // Subjects
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();

        //Hobbies
        $("#hobbies-checkbox-1").click();

        //Picture
        $("uploadPicture").click();
        $("input[type='file']").uploadFile(new File("src/test/resources/исп.png"));

        //Current adress
        $("#currentAddress").setValue("bebefiy dom, 56");

        //State and City
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        $("#submit").click();

        //Проверка
        $(".table-responsive").shouldHave(text("Nastya Nefedova"));
        $(".table-responsive").shouldHave(text("an.nefd@yandex.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("12 May,2005"));
        $(".table-responsive").shouldHave(text("Chemistry"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("Photo.jpg"));
        $(".table-responsive").shouldHave(text("Moscow street"));
        $(".table-responsive").shouldHave(text("NCR Noida"));


    }

}
