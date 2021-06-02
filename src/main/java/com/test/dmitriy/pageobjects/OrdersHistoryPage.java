package com.test.dmitriy.pageobjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OrdersHistoryPage extends HeaderPage {

    public OrdersHistoryPage findTheOrderByReference(String reference) {
        $(byText(reference)).shouldBe(visible);
        return new OrdersHistoryPage();
    }
}
