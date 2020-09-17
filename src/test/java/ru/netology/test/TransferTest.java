package ru.netology.test;
import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataClient;
import ru.netology.page.LoginPage;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataClient.getSecondCardInfo;

public class TransferTest {

    @Test
    void shouldTransferMoney() {
        open("http://localhost:7777");
        val loginPage = new LoginPage();
        val authInfo = DataClient.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val smsCode = DataClient.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(smsCode);
        int currentSumCard1 = dashboardPage.getFirstCardBalance();
        int currentSumCard2 = dashboardPage.getSecondCardBalance();
        int refillSum = 200;
        val cardPage = dashboardPage.refillCard1();
        cardPage.transfer(getSecondCardInfo(), refillSum);
        int endSumCard1 = dashboardPage.getFirstCardBalance();
        int endSumCard2 = dashboardPage.getSecondCardBalance();
        assertEquals(currentSumCard1 + refillSum, endSumCard1);
        assertEquals(currentSumCard2 - refillSum, endSumCard2);
    }
}