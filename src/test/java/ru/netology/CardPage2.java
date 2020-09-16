package ru.netology;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CardPage2 {
    private SelenideElement amount2 =  $("[data-test-id=amount] input");
    private SelenideElement cardFrom2=  $("[data-test-id=from] input");
    private SelenideElement cardTo2=  $("[data-test-id=to] input");
    private SelenideElement transferButton2=  $("[data-test-id=action-transfer]");
    private SelenideElement cancelButton2=  $("[data-test-id=action-cancel]");

    public DashboardPage Transfer (DataClient.cardFromTransfer getCardFromTransfer1) {
        amount2.setValue("200");
        cardFrom2.setValue(getCardFromTransfer1.getCard());
        transferButton2.click();
        return new DashboardPage();
    }
}

