package ru.netology;

import com.codeborne.selenide.SelenideElement;
import lombok.val;
import lombok.var;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TransferTest {

    @Test
    void shouldTransferMoney() {
        open("http://localhost:7777");
        val loginPage = new LoginPage();
        val authInfo = DataClient.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        val smsCode = DataClient.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(smsCode);
        String sumCard1 = dashboardPage.startAmount(dashboardPage.card1);
        

   //     var dashboardPage = dashboardPage.topUp();





    }




}
