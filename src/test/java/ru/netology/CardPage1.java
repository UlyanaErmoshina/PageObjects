package ru.netology;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CardPage1 {
    private SelenideElement amount1 =  $("[data-test-id=amount] input");
    private SelenideElement cardFrom=  $("[data-test-id=from] input");
    private SelenideElement cardTo=  $("[data-test-id=to] input");
    private SelenideElement transferButton=  $("[data-test-id=action-transfer]");
    private SelenideElement cancelButton=  $("[data-test-id=action-cancel]");

    public DashboardPage Transfer (DataClient.cardFromTransfer getCardFromTransfer2) {
        amount1.setValue("200");
        cardFrom.setValue(getCardFromTransfer2.getCard());
        transferButton.click();
        return new DashboardPage();
    }
}
