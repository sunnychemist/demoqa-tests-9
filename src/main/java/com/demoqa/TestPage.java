package com.demoqa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestPage {
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
    private static ElementsCollection labels =  $$("label.custom-control-label");
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
    private static SelenideElement submitButton = $("#submit");

    public TestPage open() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public TestPage fillInFirstName(String firstName) {
        firstNameInput.val(firstName);
        return this;
    }

    public TestPage fillInLastName(String lastName) {
        lastNameInput.val(lastName);
        return this;

    }

    public TestPage fillInEmail(String email) {
        userEmail.val(email);
        return this;
    }

    public TestPage fillInMobilePhone(String mobilePhone) {
        userNumber.val(mobilePhone);
        return this;
    }

    public TestPage dateOfBirthClick() {
        dateOfBirthInput.click();
        return this;
    }

    public TestPage selectMonth(String month) {
        monthSelector
                .scrollTo()
                .selectOption(month);
        return this;

    }

    public TestPage selectYear(String year) {
        yearSelector.selectOption(year);
        return this;
    }

    public TestPage selectDay(String day) {
        days.find(exactText(day)).click();
        return this;
    }
    public TestPage fillInSubject(String subject) {
        subjectsInput.val(subject);
        return this;
    }
    public TestPage selectSubject() {
        subjects
                .first()
                .click();
        return this;
    }
    public TestPage selectHobby(String hobby) {
        labels
                .filter(exactText(hobby))
                .first().scrollTo()
                .parent()
                .click();
        return this;
    }
    public TestPage selectGender(String gender) {
        labels
                .filter(exactText(gender))
                .first()
                .click();
        return this;
    }
    public TestPage fillInAddress(String address) {
        currentAddressTextArea.val(address);
        return this;
    }
    public TestPage stateClick() {
        state.click();
        return this;
    }
    public TestPage fillInStates(String stateName) {
        states
                .find(exactText(stateName))
                .click();
        return this;
    }
    public TestPage cityClick() {
        city.click();
        return this;
    }
    public TestPage fillInCities(String cityName) {
        cities
                .find(exactText(cityName))
                .click();
        return this;
    }
    public TestPage uploadPhotoInput(File photo) {
        uploadPhotoInput.uploadFile(photo);
        return this;
    }
    public TestPage pushSubmit() {
        submitButton.scrollTo().click();
        return this;
    }

    public TestPage fillInAllFields(Student student) {
        return
                fillInFirstName(student.getFirstName())
                .fillInLastName(student.getLastName())
                .fillInEmail(student.getEmail())
                .fillInMobilePhone(student.getMobileNumber())
                .dateOfBirthClick()
                .selectMonth(student.getMonth())
                .selectYear(student.getYear())
                .selectDay(student.getDay())
                .fillInSubject(student.getSubject())
                .selectSubject()
                .selectHobby(student.getHobby())
                .selectGender(student.getGender())
                .fillInAddress(student.getAddress())
                .stateClick()
                .fillInStates(student.getState())
                .cityClick()
                .fillInCities(student.getCity())
                .uploadPhotoInput(student.getPhoto())
                .pushSubmit();
    }

    public TestPage nameShouldBe(String fullName) {
        nameValue.shouldHave(exactText(fullName));
        return this;
    }
    public TestPage emailShouldBe(String email) {
        emailValue.shouldHave(exactText(email));
        return this;
    }
    public TestPage genderShouldBe(String gender) {
        genderValue.shouldHave(exactText(gender));
        return this;
    }
    public TestPage mobileNumberShouldBe(String mobilePhone) {
        mobileNumberValue.shouldHave(exactText(mobilePhone));
        return this;
    }
    public TestPage birthdayValueShouldBe(String birthday) {
        birthdayValue.shouldHave(exactText(birthday));
        return this;
    }
    public TestPage subjectValueShouldBe(String subject) {
        subjectValue.shouldHave(exactText(subject));
        return this;
    }
    public TestPage hobbyValueShouldBe(String hobby) {
        hobbyValue.shouldHave(exactText(hobby));
        return this;
    }
    public TestPage pictureValueShouldBe() {
        pictureValue.shouldHave(exactText("king.jpg"));
        return this;
    }
    public TestPage currentAddressValueShouldBe(String address) {
        currentAddressValue.shouldHave(exactText(address));
        return this;
    }
    public TestPage stateAndCityValueShouldBe(String fullAddress) {
        stateAndCityValue.shouldHave(exactText(fullAddress));
        return this;
    }

    public TestPage checkResult(Student student) {
        return nameShouldBe(student.getFullName())
                .emailShouldBe(student.getEmail())
                .genderShouldBe(student.getGender())
                .mobileNumberShouldBe(student.getMobileNumber())
                .birthdayValueShouldBe(student.getBirthday())
                .subjectValueShouldBe(student.getSubject())
                .hobbyValueShouldBe(student.getHobby())
                .pictureValueShouldBe()
                .currentAddressValueShouldBe(student.getAddress())
                .stateAndCityValueShouldBe(student.getFullAddress());
    }
}