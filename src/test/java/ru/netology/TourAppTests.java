package ru.netology;
import org.junit.jupiter.api.Test;
import ru.netology.Models.CardInfo;
import ru.netology.SelenideElements.CardBuyFrame;
import ru.netology.SelenideElements.CreditBuyFrame;
import ru.netology.SelenideElements.MainPage;
import ru.netology.TestData.CardsGenerator;

public class TourAppTests {
    @Test
    //Пустой номер карты
    public void Scenario1_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Number = "";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkCardNumberError();
    }

    @Test
    //Пустой номер карты
    public void Scenario1_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Number = "";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkCardNumberError();
    }

    @Test
    //Пустой CVV
    public void Scenario2_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.CVV = "";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkCvcError();
    }

    @Test
    //Пустой CVV
    public void Scenario2_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.CVV = "";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkCvcError();
    }

    @Test
    //Пустой месяц
    public void Scenario3_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Month = "";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkMonthError();
    }

    @Test
    //Пустой месяц
    public void Scenario3_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Month = "";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkMonthError();
    }

    @Test
    //Пустой год
    public void Scenario4_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Year = "";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkYearError();
    }

    @Test
    //Пустой год
    public void Scenario4_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Year = "";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkYearError();
    }

    @Test
    //Невалидная карта
    public void Scenario5_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GeUnknownCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkErrorNotification();
    }

    @Test
    //Невалидная карта
    public void Scenario5_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GeUnknownCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkErrorNotification();
    }

    @Test
    //Цифр в карте <16
    public void Scenario6_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GeUnknownCard();
        ci.Number = ci.Number.substring(0,15);
        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkCardNumberError();
    }

    @Test
    //Цифр в карте <16
    public void Scenario6_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Number = ci.Number.substring(0,15);

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkCardNumberError();
    }

    @Test
    //Одна цифра в месяце
    public void Scenario7_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Month = "1";
        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkMonthError();
    }

    @Test
    //Одна цифра в месяце
    public void Scenario7_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Month = "1";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkMonthError();
    }

    @Test
    //Одна цифра в годе
    public void Scenario8_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Year = "3";
        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkYearError();
    }

    @Test
    //Одна цифра в годе
    public void Scenario8_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Year = "3";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkYearError();
    }

    @Test
    //Истекшая карта
    public void Scenario9_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Month = "05";
        ci.Year = "23";
        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkCardDateError();
    }

    @Test
    //Истекшая карта
    public void Scenario9_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Month = "05";
        ci.Year = "23";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkCardDateError();
    }

    @Test
    //Владелец на русском
    public void Scenario10_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Owner = "ИВАНОВ ИВАН";
        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkOwnerError();
    }

    @Test
    //Владелец на русском
    public void Scenario10_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Owner = "ИВАНОВ ИВАН";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkOwnerError();
    }

    @Test
    //Владелец слишком длинное значение
    public void Scenario11_Credit() {
        //Arrange
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Owner = "ИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАН";
        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkOwnerError();
    }

    @Test
    //Владелец слишком длинное значение
    public void Scenario11_Card() {
        //Arrange
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();
        ci.Owner = "ИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАНИВАНОВИВАН";

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();

        //assert
        cp.checkOwnerError();
    }
}
