import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ilgiz");
        $("#lastName").setValue("Gafarov");
        $("#userEmail").setValue("igafarov90@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day.react-datepicker__day--017").click();
        $("#subjectsInput").setValue("phy").pressEnter();
        $("#subjectsInput").setValue("art").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").val("Russia, 46°23'45.0\"N 48°05'49.1\"E");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("Thanks for submitting the form"));
        $$(".table thead").get(0).shouldHave(text("Label Values"));
        $$(".table tbody tr").get(0).shouldHave(text("Student Name Ilgiz Gafarov"));
        $$(".table tbody tr").get(1).shouldHave(text("Student Email igafarov90@mail.ru"));
        $$(".table tbody tr").get(2).shouldHave(text("Gender Male"));
        $$(".table tbody tr").get(3).shouldHave(text("Mobile 1111111111"));
        $$(".table tbody tr").get(4).shouldHave(text("Date of Birth 17 December,1990"));
        $$(".table tbody tr").get(5).shouldHave(text("Subjects Physics, Arts"));
        $$(".table tbody tr").get(6).shouldHave(text("Hobbies Sports, Music"));
        $$(".table tbody tr").get(7).shouldHave(text("Picture test.jpg"));
        $$(".table tbody tr").get(8).shouldHave(text("Address Russia, 46°23'45.0\"N 48°05'49.1\"E"));
        $$(".table tbody tr").get(9).shouldHave(text("State and City NCR Delhi"));
    }
}
