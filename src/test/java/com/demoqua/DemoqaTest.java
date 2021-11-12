package com.demoqua;

import com.codeborne.selenide.Configuration;
import com.demoqa.Student;
import com.demoqa.TestPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DemoqaTest {
        Student student;
        TestPage page = new TestPage();

        @BeforeAll
        public static void before() {
                Configuration.browserSize = "1920x1080";
        }

        @Test
        void fillBox() {
                student = new Student.StudentBuilder().createStudent();
                page
                        .open()
                        .fillInAllFields(student)
                        .checkResult(student);
        }
}