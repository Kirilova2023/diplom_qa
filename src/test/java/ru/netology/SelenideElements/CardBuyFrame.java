package ru.netology.SelenideElements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;

public class CardBuyFrame extends BaseCardData {

    public CardBuyFrame(){
        heading = $$(".heading").find(Condition.exactText("Оплата по карте"));
        heading.should(Condition.visible);
    }

}
