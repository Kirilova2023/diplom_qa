package ru.netology.SelenideElements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;

public class CreditBuyFrame extends BaseCardData{

    public CreditBuyFrame(){
        heading = $$(".heading").find(Condition.exactText("Кредит по данным карты"));
        heading.should(Condition.visible);
    }
}
