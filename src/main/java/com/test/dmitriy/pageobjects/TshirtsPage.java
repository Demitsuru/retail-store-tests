package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TshirtsPage {
    private By fadedTshirt = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
    private By addToCartButton = By.xpath("//span[contains(text(), 'Add to cart')]");
    private By proceedToCheckoutButton = By.xpath("//span[contains(text(), 'Proceed to checkout')]");

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
