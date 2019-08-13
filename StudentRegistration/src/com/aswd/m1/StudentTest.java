package com.aswd.m1;

import com.aswd.m1.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student = new Student();


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        student.firstName="wegweg";
        student.lastName="fjjrt";
        student.gender="Male";
        student.setTel("363547");
        student.setAddress("2wegwegewh54745u");
        student.course="html";
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void validFname() {
        assertTrue(student.ValidFname());
    }

    @org.junit.jupiter.api.Test
    void validLname() {
        assertTrue(student.ValidLname());
    }

    @org.junit.jupiter.api.Test
    void validGender() {
        assertTrue(student.ValidGender());
    }

    @org.junit.jupiter.api.Test
    void validAddress() {
        assertTrue(student.ValidAddress());
    }

    @org.junit.jupiter.api.Test
    void validTel() {
        assertTrue(student.ValidTel());
    }

}