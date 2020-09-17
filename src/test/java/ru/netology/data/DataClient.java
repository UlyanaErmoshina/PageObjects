package ru.netology.data;

import lombok.Value;

public class DataClient {
    private DataClient() {
    }


    @Value
    public static class AuthInfo {
        private String login;
        private String password;

    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value

    public static class VerificationCode {
        private String code;

    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value

    public static class cardInfo {
        private String card;
    }

    public static cardInfo getFirstCardInfo() {
        return new cardInfo("5559 0000 0000 0001");
    }

        public static cardInfo getSecondCardInfo() {
            return new cardInfo("5559 0000 0000 0002");
        }
    }



