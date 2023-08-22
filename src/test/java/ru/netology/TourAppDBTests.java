package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.DBWrapper.DBAdapter;
import ru.netology.Models.CardInfo;
import ru.netology.Models.CreditEntity;
import ru.netology.Models.OrderEntity;
import ru.netology.Models.PaymentEntity;
import ru.netology.SelenideElements.CardBuyFrame;
import ru.netology.SelenideElements.CreditBuyFrame;
import ru.netology.SelenideElements.MainPage;
import ru.netology.TestData.CardsGenerator;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class TourAppDBTests {
    private DBAdapter dbAdapter = new DBAdapter();

    public TourAppDBTests() throws SQLException{
    }

    @Test
    //Действительная карта - покупка по карте - сумма
    public void Scenario1_Card_Sum() throws SQLException {
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkSuccessNotification();

        //assert
        PaymentEntity ent = dbAdapter.GetPaymentEntity();

        Assertions.assertEquals(45000, ent.amount);
    }

    @Test
    //Действительная карта - покупка по карте - статус
    public void Scenario1_Card_Status() throws SQLException {
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkSuccessNotification();

        //assert
        PaymentEntity ent = dbAdapter.GetPaymentEntity();

        Assertions.assertEquals("APPROVED", ent.status);
    }

    @Test
    //Действительная карта - покупка по карте - другие поля
    public void Scenario1_Card_Other() throws SQLException {
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkSuccessNotification();

        //assert
        PaymentEntity ent = dbAdapter.GetPaymentEntity();

        Assertions.assertNotEquals("",ent.id);
        Assertions.assertNotEquals("",ent.transaction_id);
        Assertions.assertNotNull (ent.created);
    }

    @Test
    //Действительная карта - покупка по карте - OrderEntity
    public void Scenario1_Card_OrderEntity() throws SQLException {
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkSuccessNotification();

        //assert
        OrderEntity ent = dbAdapter.GetOrderEntity();

        Assertions.assertNotEquals("",ent.id);
        Assertions.assertNotEquals("",ent.payment_id);
        Assertions.assertNotNull (ent.created);
    }


    @Test
    //Недействительная карта - покупка в кредит - статус
    public void Scenario3_Credit_Status() throws SQLException {
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetDeclinedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        CreditEntity ent = dbAdapter.GetCreditEntity();

        Assertions.assertEquals("DECLINED", ent.status);
    }

    @Test
    //Недействительная карта - покупка в кредит - другие поля
    public void Scenario3_Credit_Other() throws SQLException {
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetDeclinedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        CreditEntity ent = dbAdapter.GetCreditEntity();

        Assertions.assertNotEquals("",ent.id);
        Assertions.assertNotEquals("",ent.bank_id);
        Assertions.assertNotNull (ent.created);
    }

    @Test
    //Недействительная карта - покупка в кредит - OrderEntity
    public void Scenario3_Credit_OrderEntity() throws SQLException {
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetDeclinedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        OrderEntity ent = dbAdapter.GetOrderEntity();

        Assertions.assertNotEquals("",ent.id);
        Assertions.assertNotEquals("",ent.payment_id);
        Assertions.assertNotNull (ent.created);
    }

    @Test
    //Недействительная карта - покупка по карте - сумма
    public void Scenario2_Card_Sum() throws SQLException {
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetDeclinedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        PaymentEntity ent = dbAdapter.GetPaymentEntity();

        Assertions.assertEquals(45000, ent.amount);
    }

    @Test
    //Недействительная карта - покупка по карте - статус
    public void Scenario2_Card_Status() throws SQLException {
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetDeclinedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        PaymentEntity ent = dbAdapter.GetPaymentEntity();

        Assertions.assertEquals("DECLINED", ent.status);
    }

    @Test
    //Недействительная карта - покупка по карте - сумма
    public void Scenario2_Card_Other() throws SQLException {
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetDeclinedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        PaymentEntity ent = dbAdapter.GetPaymentEntity();

        Assertions.assertNotEquals("",ent.id);
        Assertions.assertNotEquals("",ent.transaction_id);
        Assertions.assertNotNull (ent.created);
    }

    @Test
    //Недействительная карта - покупка по карте - OrderEntity
    public void Scenario2_Card_OrderEntity() throws SQLException {
        MainPage mp = new MainPage();
        CardBuyFrame cp = mp.openCardBuyFrame();
        CardInfo ci = CardsGenerator.GetDeclinedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        OrderEntity ent = dbAdapter.GetOrderEntity();

        Assertions.assertNotEquals("",ent.id);
        Assertions.assertNotEquals("",ent.payment_id);
        Assertions.assertNotNull (ent.created);
    }

    @Test
    //Действительная карта - покупка в кредит - статус
    public void Scenario4_Credit_Status() throws SQLException {
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        CreditEntity ent = dbAdapter.GetCreditEntity();

        Assertions.assertEquals("APPROVED", ent.status);
    }

    @Test
    //Недействительная карта - покупка в кредит - другие поля
    public void Scenario4_Credit_Other() throws SQLException {
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        CreditEntity ent = dbAdapter.GetCreditEntity();

        Assertions.assertNotEquals("",ent.id);
        Assertions.assertNotEquals("",ent.bank_id);
        Assertions.assertNotNull (ent.created);
    }

    @Test
    //действительная карта - покупка в кредит - OrderEntity
    public void Scenario4_Credit_OrderEntity() throws SQLException {
        MainPage mp = new MainPage();
        CreditBuyFrame cp = mp.openCreditFrame();
        CardInfo ci = CardsGenerator.GetApprovedCard();

        cp.SetupCardData(ci);
        //act
        cp.clickContinueButton();
        //wait
        cp.checkErrorNotification();

        //assert
        OrderEntity ent = dbAdapter.GetOrderEntity();

        Assertions.assertNotEquals("",ent.id);
        Assertions.assertNotEquals("",ent.payment_id);
        Assertions.assertNotNull (ent.created);
    }

    @BeforeEach
    public void CleanUpDB() throws SQLException {
        dbAdapter.CleanUp();
    }
}
