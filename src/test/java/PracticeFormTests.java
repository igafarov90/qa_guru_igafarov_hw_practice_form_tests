import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @Test
    void successFillPracticeFormAllFields() {
        practiceFormPage.openPage()
                .setFirstName("Ilgiz")
                .setLastName("Gafarov")
                .setUserEmail("igafarov@it.tcinet.ru")
                .setGender("Male")
                .setUserNumber("9371247471")
                .setDateOfBirth("1990", "December", "17")
                .setSubjects("Art")
                .setSubjects("Phy")
                .setHobbies("Music")
                .setHobbies("Reading")
                .uploadPicture("test.jpg")
                .setCurrentAddress("Russia, 46°23'45.0\"N 48°05'49.1E\"")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();
        practiceFormPage.checkModalWindowHeader("Thanks for submitting the form")
                .checkTableResult("Student Name", "Ilgiz Gafarov")
                .checkTableResult("Student Email", "igafarov@it.tcinet.ru")
                .checkTableResult("Gender", "Male")
                .checkTableResult("Mobile", "9371247471")
                .checkTableResult("Date of Birth", " 17 December,1990")
                .checkTableResult("Subjects", "Arts, Physics")
                .checkTableResult("Hobbies", "Music, Reading ")
                .checkTableResult("Picture", "test.jpg")
                .checkTableResult("Address", "Russia, 46°23'45.0\"N 48°05'49.1E\"")
                .checkTableResult("State and City", "NCR Delhi");
    }

    @Test
    void successFillPracticeFormRequiredFields() {
        practiceFormPage.openPage()
                .setFirstName("Ilgiz")
                .setLastName("Gafarov")
                .setGender("Male")
                .setUserNumber("9371247471")
                .setDateOfBirth("1990", "December", "17")
                .pressSubmit();
        practiceFormPage.checkModalWindowHeader("Thanks for submitting the form")
                .checkTableResult("Student Name", "Ilgiz Gafarov")
                .checkTableResult("Gender", "Male")
                .checkTableResult("Mobile", "9371247471")
                .checkTableResult("Date of Birth", " 17 December,1990");
    }

    @ParameterizedTest()
    @ValueSource(strings = {
            "",
            "десятьбукв",
            "111111111"
    })
    void fillMobileNumberByInvalidData(String value) {
        practiceFormPage.openPage()
                .setUserNumber(value)
                .pressSubmit();
        practiceFormPage.checkBorderColorUserNumberInput("border-color", "rgb(220, 53, 69)");
    }
}
