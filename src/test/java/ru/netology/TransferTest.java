package ru.netology;

import com.codeborne.selenide.SelenideElement;
import lombok.val;
import lombok.var;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TransferTest {

    @Test
    void shouldTransferMoney() {
        open("http://localhost:7777");
        val loginPage = new LoginPage();
        val authInfo = DataClient.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        val smsCode = DataClient.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(smsCode);
        int currentSumCard1 = dashboardPage.getFirstCardBalance();
        int currentSumCard2 = dashboardPage.getSecondCardBalance();
        int refillSum = 200;
        var cardPage1 = dashboardPage.refillCard1();
        int endSumCard1 = dashboardPage.getFirstCardBalance();
        int endSumCard2 = dashboardPage.getSecondCardBalance();
        assertEquals(currentSumCard1-refillSum, endSumCard1);
        assertEquals(currentSumCard2-refillSum, endSumCard2);

   //     var dashboardPage = dashboardPage.topUp();


    }

}
