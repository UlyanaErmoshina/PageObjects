package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataClient;

import static com.codeborne.selenide.Selenide.$;

public class CardPage {
    private SelenideElement amount1 =  $("[data-test-id=amount] input");
    private SelenideElement cardFrom=  $("[data-test-id=from] input");
    private SelenideElement cardTo=  $("[data-test-id=to] input");
    private SelenideElement transferButton=  $("[data-test-id=action-transfer]");
    private SelenideElement cancelButton=  $("[data-test-id=action-cancel]");

    public void transfer (DataClient.cardInfo cardInfo,int amount) {
        amount1.setValue(String.valueOf(amount));
        cardFrom.setValue(cardInfo.getCard());
        transferButton.click();
    }
}
