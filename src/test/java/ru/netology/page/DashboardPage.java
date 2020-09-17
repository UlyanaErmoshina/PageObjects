package ru.netology.page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement card1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement refillButton1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private SelenideElement card2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement refillButton2 = $(card2 + " button");
    private SelenideElement reload = $("[data-test-id=action-reload]");
    private final String startBalance = "баланс: ";
    private final String finishBalance = " р.";
    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }
    public CardPage refillCard1() {
        refillButton1.click();
        return new CardPage();
    }
    public CardPage refillCard2() {
        refillButton2.click();
        return new CardPage();
    }
    public String startAmount(SelenideElement card) {
        return card.getText();
    }
    public int getFirstCardBalance() {
        String firstValue = card1.text();
        return findOutBalance(firstValue);
    }
    public int getSecondCardBalance() {
        String secondValue = card2.text();
        return findOutBalance(secondValue);
    }
    private int findOutBalance(String text) {
        val start = text.indexOf(startBalance);
        val finish = text.indexOf(finishBalance);
        val value = text.substring(start + startBalance.length(), finish);
        return Integer.parseInt(value);
    }
}