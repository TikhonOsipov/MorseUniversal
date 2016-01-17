package com.tixon.longpress;

public class MorseParser {
    public static String parse(String code, String[] codes, String[] symbols) {
        String symbol = "";
        for(int i = 0; i < codes.length; i++) {
            if(codes[i].equals(code)) {
                symbol = symbols[i];
            }
        }
        return symbol;
    }
}
