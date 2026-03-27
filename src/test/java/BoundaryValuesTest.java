import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class BoundaryValuesTest {
    @Test
    public void secondTest() {
        open("https://demoqa.com/automation-practice-form");
        // First Name
        $("#firstName").setValue("A");

        // Last Name
        $("#lastName").setValue("F");

        //Gender
        $("#genterWrapper").$(byText("Female")).click();

        // Mobile Number
        $("#userNumber").setValue("1234567890");

        $("#submit").click();

        //Проверка
        $(".table-responsive").shouldHave(text("A F"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567890"));
    }
}
