package com.github.demo.aop;

import com.github.demo.TestConfig;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.with;
import static org.hamcrest.CoreMatchers.containsString;

class StudentControllerTest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = TestConfig.host;
    }

    // test @Qualifier
    @Test
    void should_get_student_summary_successful() {
        String expect = "i am a good student! The teacher said I was great. The HeadMaster said I was very clever.";
        with().when().get("student/summary").then().assertThat().statusCode(200)
                .body(containsString(expect));
    }
}