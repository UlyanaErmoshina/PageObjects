package ru.netology;

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

    public static class cardFromTransfer {
        private String card;
    }

    public static cardFromTransfer getCardFromTransfer1(AuthInfo authInfo) {
        return new cardFromTransfer("5559 0000 0000 0001");
    }
    @Value

    public static class cardFromTransfer2 {
        private String card;
    }

        public static cardFromTransfer2 getCardFromTransfer2(AuthInfo authInfo) {
            return new cardFromTransfer2("5559 0000 0000 0002");
        }
    }



