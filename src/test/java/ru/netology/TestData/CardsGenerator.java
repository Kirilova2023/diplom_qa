package ru.netology.TestData;

import ru.netology.Models.CardInfo;

public class CardsGenerator {
    public static CardInfo GetApprovedCard(){
        CardInfo ci = new CardInfo();
        ci.CVV = "123";
        ci.Month = "08";
        ci.Year = "27";
        ci.Owner = "IVAN IVANOV";
        ci.Number = "4444 4444 4444 4441";
        return ci;
    }

    public static CardInfo GetDeclinedCard(){
        CardInfo ci = new CardInfo();
        ci.CVV = "123";
        ci.Month = "08";
        ci.Year = "27";
        ci.Owner = "IVAN IVANOV";
        ci.Number = "4444 4444 4444 4442";
        return ci;
    }

    public static CardInfo GeUnknownCard(){
        CardInfo ci = new CardInfo();
        ci.CVV = "123";
        ci.Month = "08";
        ci.Year = "27";
        ci.Owner = "IVAN IVANOV";
        ci.Number = "4444 4444 4444 4444";
        return ci;
    }
}
