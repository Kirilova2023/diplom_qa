package ru.netology.SelenideElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.Models.CardInfo;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BaseCardData {
    protected SelenideElement heading;

    protected ElementsCollection formField = $$(".input__inner");
    protected SelenideElement cardNumberField = formField.findBy(Condition.text("Номер карты")).$(".input__control");
    protected SelenideElement cardMonthField = formField.findBy(Condition.text("Месяц")).$(".input__control");
    protected SelenideElement cardYearField = formField.findBy(Condition.text("Год")).$(".input__control");
    protected SelenideElement cardOwnerField = formField.findBy(Condition.text("Владелец")).$(".input__control");
    protected SelenideElement cardCvcField = formField.findBy(Condition.text("CVC/CVV")).$(".input__control");
    protected SelenideElement continueButton = $$("button").find(Condition.exactText("Продолжить"));
    protected SelenideElement successNotification = $(".notification_status_ok");
    protected SelenideElement errorNotification = $(".notification_status_error");

    public void SetupCardData(CardInfo cardInfo){
         cardNumberField.setValue(cardInfo.number);
         cardCvcField.setValue(cardInfo.cvv);
         cardMonthField.setValue(cardInfo.month);
         cardYearField.setValue(cardInfo.year);
         cardOwnerField.setValue(cardInfo.owner);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void checkSuccessNotification() {
        //стандартное уведомление ждет 4 секунды, операция занимает дольше
        successNotification.should(Condition.visible,  Duration.ofSeconds(15));
    }

    public void checkErrorNotification() {
        //стандартное уведомление ждет 4 секунды, операция занимает дольше
        errorNotification.should (Condition.visible, Duration.ofSeconds(15));
    }

    public void checkCardNumberError() {
        formField.findBy(Condition.text("Номер карты")).$(".input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    public void checkCardDateError() {
        formField.findBy(Condition.text("Месяц")).$(".input__sub").shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void checkCardValidError() {
        formField.findBy(Condition.text("Год")).$(".input__sub").shouldHave(Condition.exactText("Истёк срок действия карты"));
    }

    public void checkCvcError() {
        formField.findBy(Condition.text("CVC/CVV")).$(".input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    public void checkOwnerError() {
        formField.findBy(Condition.text("Владелец")).$(".input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void checkMonthError() {
        formField.findBy(Condition.text("Месяц")).$(".input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    public void checkYearError() {
        formField.findBy(Condition.text("Год")).$(".input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }


}
