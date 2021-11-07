package com.demoqua;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.TestPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {
        TestPage page = new TestPage();
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
                Configuration.browserSize = "1920x1080";
        }

        @Test
        void fillBox() {
                File photo = new File("src/test/resources/king.jpg");
                page
                        .open()
                        .fillInFirstName(firstName)
                        .fillInLastName(lastName)
                        .fillInEmail(email)
                        .fillInMobilePhone(mobilePhone)
                        .dateOfBirthClick()
                        .selectMonth(month)
                        .selectYear(year)
                        .selectDay(day)
                        .fillInSubject(subject)
                        .selectSubject()
                        .selectHobby()
                        .selectSex()
                        .fillInAddress(address)
                        .stateClick()
                        .fillInStates(stateName)
                        .cityClick()
                        .fillInCities(cityName)
                        .uploadPhotoInput(photo)
                        .pushSubmit()
                        .nameShouldBe(firstName, lastName)
                        .emailShouldBe(email)
                        .genderShouldBe()
                        .mobileNumberShouldBe(mobilePhone)
                        .birthdayValueShouldBe(day, month, year)
                        .subjectValueShouldBe(subject)
                        .hobbyValueShouldBe()
                        .pictureValueShouldBe()
                        .currentAddressValueShouldBe(address)
                        .stateAndCityValueShouldBe(stateName, cityName);
        }
}