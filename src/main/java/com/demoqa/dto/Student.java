package com.demoqa.dto;

import com.github.javafaker.Faker;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class Student {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobileNumber;
    private String day;
    private String month;
    private String year;
    private String subject;
    private static List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
    private static List<String> subjects = Arrays.asList("Maths", "Arts", "Chemistry", "Computer Science", "Physics");
    private static List<String> states = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    private static Map<String, List<String>> cities = new HashMap<>();
    private String hobby;
    private String address;
    private String state;
    private String city;
    private File photo;
    private static LocalDate date = LocalDate.now().minusYears(new Random().nextInt(20) - 18);
    private static String dateFormat = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).localizedBy(Locale.UK));


    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getDay() {
        return day;
    }
    public String getMonth() {
        return month;
    }
    public String getYear() {
        return year;
    }
    public String getSubject() {
        return subject;
    }

    private static String getRandomHobby() {
        return hobbies.get(new Random().nextInt(hobbies.size()-1));
    }

    private static String getRandomSubject() {
        return subjects.get(new Random().nextInt(subjects.size()-1));
    }

    private static String getRandomState() {
        return states.get(new Random().nextInt(subjects.size()-1));
    }

    private static String getRandomCity(String state) {
        cities.put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        cities.put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
        cities.put("Haryana", Arrays.asList("Karnal", "Panipat"));
        cities.put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
        return cities.get(state).get(new Random().nextInt(cities.get(state).size()-1));
    }

    public String getAddress() {
        return address;
    }

    public String getHobby() {
        return hobby;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public File getPhoto() {
        return photo;
    }

    public String getFullName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    public String getBirthday() {
        return String.format("%s %s,%s", getDay(), getMonth(), getYear());
    }

    public String getFullAddress() {
        return String.format("%s %s", getState(), getCity());
    }

    private Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    private Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    private Student setEmail(String email) {
        this.email = email;
        return this;
    }
    private Student setGender(String gender) {
        this.gender = gender;
        return this;
    }
    private Student setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }
    private Student setDay(String day) {
        this.day = day;
        return this;
    }
    private Student setMonth(String month) {
        this.month = month;
        return this;
    }
    private Student setYear(String year) {
        this.year = year;
        return this;
    }
    private Student setHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    private Student setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    private Student setAddress(String address) {
        this.address = address;
        return this;
    }

    private Student setState(String state) {
        this.state = state;
        return this;
    }

    private Student setCity(String city) {
        this.city = city;
        return this;
    }

    private Student setPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    private Student() {

    }

    public static class StudentBuilder {
        static Faker faker = new Faker();
        private Student student;

        public StudentBuilder() {
            student = new Student();
        }

        public Student createStudent() {
            String state = getRandomState();
            return student
                    .setFirstName(faker.name().firstName())
                    .setLastName(faker.name().lastName())
                    .setEmail(faker.internet().emailAddress())
                    .setGender(faker.demographic().sex())
                    .setMobileNumber(faker.phoneNumber().subscriberNumber(10))
                    .setDay(splitDate(dateFormat).get(0))
                    .setMonth(splitDate(dateFormat).get(1))
                    .setYear(splitDate(dateFormat).get(2))
                    .setHobby(getRandomHobby())
                    .setSubject(getRandomSubject())
                    .setAddress(faker.address().fullAddress())
                    .setState(state)
                    .setCity(getRandomCity(state))
                    .setPhoto(new File("src/test/resources/king.jpg"));
        }

        private static List<String> splitDate(String date) {
            return List.of(String.valueOf(date).split(" "));
        }
    }
}