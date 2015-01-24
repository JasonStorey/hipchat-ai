package com.jasonstorey.hipchat.ai;

public class Tokeniser {
    public static String[] extractTokens(String text) {
        String[] tokens = text.trim().split("\\s+");

        return tokens;
    }
}
