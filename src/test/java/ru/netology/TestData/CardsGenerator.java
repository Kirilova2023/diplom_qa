package ru.netology.TestData;

import ru.netology.Models.CardInfo;

import java.time.Year;

public class CardsGenerator {

    //Месяц будущего года роли не играет, поэтому сгенерировала только год+1
    private static String getNextYear(){
        return String.valueOf(Year.now().getValue()+1).substring(2);
    }

    public static CardInfo GetApprovedCard(){
        CardInfo ci = new CardInfo();
        ci.cvv = "123";
        ci.month = "08";
        ci.year = getNextYear();
        ci.owner = "IVAN IVANOV";
        ci.number = "4444 4444 4444 4441";
        return ci;
    }

    public static CardInfo GetDeclinedCard(){
        CardInfo ci = new CardInfo();
        ci.cvv = "123";
        ci.month = "08";
        ci.year = getNextYear();
        ci.owner = "IVAN IVANOV";
        ci.number = "4444 4444 4444 4442";
        return ci;
    }

    public static CardInfo GeUnknownCard(){
        CardInfo ci = new CardInfo();
        ci.cvv = "123";
        ci.month = "08";
        ci.year = getNextYear();
        ci.owner = "IVAN IVANOV";
        ci.number = "4444 4444 4444 4444";
        return ci;
    }
}
