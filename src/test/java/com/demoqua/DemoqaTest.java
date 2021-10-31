package com.demoqua;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {

        private static SelenideElement firstNameInput = $("#firstName");
        private static SelenideElement lastNameInput = $("#lastName");
        private static SelenideElement userEmail = $("#userEmail");
        private static SelenideElement userNumber = $("#userNumber");
        private static SelenideElement subjectsInput = $("#subjectsInput");
        private static SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
        private static SelenideElement dataContainer = $(".react-datepicker");
        private static SelenideElement monthSelector = dataContainer.$(".react-datepicker__month-select");
        private static SelenideElement yearSelector = dataContainer.$(".react-datepicker__year-select");
        private static ElementsCollection days = dataContainer.$$x(".//div[contains(@class, 'react-datepicker__day')]");
        private static SelenideElement sexRadioButton = $x("//input[@id='gender-radio-2']//ancestor::div[1]");
        private static ElementsCollection subjects = $$x(".//div[contains(@class, 'subjects-auto-complete__menu')]//*");
        private static SelenideElement state = $("#state");
        private static ElementsCollection states = state.$$x(".//div[contains(@class, 'menu')]//*");
        private static SelenideElement city = $("#city");
        private static ElementsCollection cities = city.$$x(".//div[contains(@class, 'menu')]//*");
        private static SelenideElement uploadPhotoInput = $("#uploadPicture");
        private static SelenideElement sportCheckBox = $("#hobbies-checkbox-1");
        private static SelenideElement currentAddressTextArea = $("#currentAddress");
        private static SelenideElement modalContainer = $(".table-responsive");
        private static SelenideElement nameValue = modalContainer.$x(".//tr[1]//td[2]");
        private static SelenideElement emailValue = modalContainer.$x(".//tr[2]//td[2]");
        private static SelenideElement genderValue = modalContainer.$x(".//tr[3]//td[2]");
        private static SelenideElement mobileNumberValue = modalContainer.$x(".//tr[4]//td[2]");
        private static SelenideElement birthdayValue = modalContainer.$x(".//tr[5]//td[2]");
        private static SelenideElement subjectValue = modalContainer.$x(".//tr[6]//td[2]");
        private static SelenideElement hobbyValue = modalContainer.$x(".//tr[7]//td[2]");
        private static SelenideElement pictureValue = modalContainer.$x(".//tr[8]//td[2]");
        private static SelenideElement currentAddressValue = modalContainer.$x(".//tr[9]//td[2]");
        private static SelenideElement stateAndCityValue = modalContainer.$x(".//tr[10]//td[2]");

        private String firstName = "Sunny";
        private String lastName = "Chemist";
        private String email = "sun@sun.ru";
        private String mobilePhone = "1234567890";
        private String month = "September";
        private String year = "1988";
        private String day = "22";
        private String subject = "Chemistry";
        private String address = "My address";
        private String stateName = "Haryana";
        private String cityName = "Karnal";

        @BeforeAll
        public static void before() {
                Configuration.startMaximized = true;
        }

        @Test
        void fillBox() {
                File photo = new File("src/test/resources/king.jpg");
                open("https://demoqa.com/automation-practice-form");
                firstNameInput.val(firstName);
                lastNameInput.val(lastName);
                userEmail.val(email);
                userNumber.val(mobilePhone);
                dateOfBirthInput.click();
                monthSelector.selectOption(month);
                yearSelector.selectOption(year);
                days.find(exactText(day)).click();
                subjectsInput.val(subject);
                subjects
                        .first()
                        .click();
                sportCheckBox
                        .scrollTo()
                        .parent()
                        .click();
                sexRadioButton.click();
                currentAddressTextArea.val(address);
                state.click();
                states
                        .find(exactText(stateName))
                        .click();
                city.click();
                cities
                        .find(exactText(cityName))
                        .click();
                uploadPhotoInput.uploadFile(photo);
                $("#submit").scrollTo().click();

                nameValue.shouldHave(exactText(String.format("%s %s", firstName, lastName)));
                emailValue.shouldHave(exactText(email));
                genderValue.shouldHave(exactText("Female"));
                mobileNumberValue.shouldHave(exactText(mobilePhone));
                birthdayValue.shouldHave(exactText(String.format("%s %s,%s", day, month, year)));
                subjectValue.shouldHave(exactText(subject));
                hobbyValue.shouldHave(exactText("Sports"));
                pictureValue.shouldHave(exactText("king.jpg"));
                currentAddressValue.shouldHave(exactText(address));
                stateAndCityValue.shouldHave(exactText(String.format("%s %s", stateName, cityName)));
        }
}