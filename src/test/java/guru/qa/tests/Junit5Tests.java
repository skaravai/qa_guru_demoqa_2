package guru.qa.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class Junit5Tests {

    @BeforeAll
    static void initDB() {
        System.out.println("### BeforeAll");
    }
    @BeforeEach
    void openYaPage() {
        System.out.println("### BeforeEach");
        Selenide.open("https://ya.ru");
    }

    @AfterEach
    void close() {
        System.out.println("### AfterEach");
        WebDriverRunner.closeWindow();
    }
    @Test
    void assertTest() {
        System.out.println("### @Test0");
        Assertions.assertTrue(true);
    }

    @Test
    void assertTest1() {
        System.out.println("### @Test1");
        Assertions.assertTrue(true);
    }

    @Test
    void assertTest2() {
        System.out.println("### @Test2");
        Assertions.assertTrue(true);
    }

    @Test
    void assertTest3() {
        System.out.println("### @Test3");
        Assertions.assertTrue(true);
    }
}
