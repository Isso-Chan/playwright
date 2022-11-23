package com.pages;

import com.microsoft.playwright.Page;

public class HomePageCucumber {

    private Page page;

// Locator — — — -

    String productName_1 ="id=item_4_title_link";

//initialize Page using constructor

    public HomePageCucumber(Page page) {

        this.page =page;}

//Method

    public String productName() {

        String productName = page.textContent(productName_1);

        return productName;}

    public String getProductName() {
        return "Sauce Labs Backpack";
    }
}
