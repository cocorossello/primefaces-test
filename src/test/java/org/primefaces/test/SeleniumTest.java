package org.primefaces.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SeleniumTest {

    @Test
    public void keyFilterTest() {
        open("http://localhost:8080/primefaces-test/");
        $(".some-input").getWrappedElement().sendKeys("ج");
        $(".some-input").shouldBe(Condition.empty);
    }
}
