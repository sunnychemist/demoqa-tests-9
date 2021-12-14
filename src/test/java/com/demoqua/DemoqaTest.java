package com.demoqua;

import com.demoqa.dto.Student;
import com.demoqa.pages.TestPage;
import org.junit.jupiter.api.Test;

public class DemoqaTest extends BaseTest{
        Student student;
        TestPage page = new TestPage();

        @Test
        void fillBox() {
                student = new Student.StudentBuilder().createStudent();
                page
                    .open()
                    .fillInAllFields(student)
                    .checkResult(student);
        }
}