package ru.netology.SelenideElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {


    private SelenideElement cardButton = $$("#root > div > button:nth-child(3)").first();
    private SelenideElement creditButton = $$("#root > div > button.button.button_view_extra.button_size_m.button_theme_alfa-on-white").first();

    public MainPage() {
        open(System.getProperty("app.url"));
    }


    public CardBuyFrame openCardBuyFrame() {
        cardButton.click();
        return new CardBuyFrame();
    }

    public CreditBuyFrame openCreditFrame() {
        creditButton.click();
        return new CreditBuyFrame();
    }

}
