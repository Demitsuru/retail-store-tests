package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Optional;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OrderConfirmationPage extends HeaderPage {
    private final By confirmOrderButton = By.xpath("//span[contains(text(),'I confirm my order')]");
    private final By orderConfirmationText = By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]");
    private final By orderInformation = By.xpath("//div[@class='box']");
    private final String pattern = "[A-Z]";

    public OrderConfirmationPage confirmOrderAndCheckConfirmationText(){
        $(confirmOrderButton).click();
        $(orderConfirmationText).shouldBe(visible);
        return new OrderConfirmationPage();
    }

    public Optional<String> extractOrderReference(){
        return Arrays.stream(
                $(orderInformation).text().split(" "))
                .filter( string -> string.matches(pattern))
                .findFirst();
    }
}
