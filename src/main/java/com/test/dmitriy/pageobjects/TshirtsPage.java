package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TshirtsPage {
    private final By fadedTshirt = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
    private final By addToCartButton = By.xpath("//span[contains(text(), 'Add to cart')]");
    private final By proceedToCheckoutButton = By.xpath("//span[contains(text(), 'Proceed to checkout')]");

    public TshirtsPage addTshirtToTheCart(){
        $(fadedTshirt).hover();
        $(addToCartButton).click();
        return new TshirtsPage();
    }

    public CheckoutPage proceedToCheckoutPage(){
        $(proceedToCheckoutButton).click();
        return new CheckoutPage();
    }
}
