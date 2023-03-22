package com.example.lab_2_shvarts;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Encrypt {
    public static String result(String text, String key) {
        StringBuilder result = new StringBuilder();

        String leters = "абвгдеєжзиіїйклмнопрстуфхцчшщьюя";//32
        String Leters = "АБВГДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";//32

        String p = "";

        key += key.repeat(text.length() / key.length());

        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);

            if (t == '!' || t == '?' || t == '.' || t == ',' || t == '\'' || t == '\n') {
                result.append(t);
            }
            else {
                String l = "";
                if (isUpperCase(t)){
                    l = Leters;
                    key = key.toUpperCase();
                } else if (isLowerCase(t)){
                    l = leters;
                    key = key.toLowerCase();
                }

                int r = 0, x = 0;
                char k = key.charAt(i);

                for (int j = 0; j < l.length(); j++) {
                    if (t == l.charAt(j)) {
                        r = j + 1;
                    }
                }
                for (int j = 0; j < l.length(); j++) {
                    if (k == l.charAt(j)) {
                        x = j + 1;
                    }
                }

                int sum = r + x;
                sum = sum % 32;
                if (sum % 32 == 0) {
                    sum = 32;
                }
                if (Character.isWhitespace(t)){
                    result.append(key.charAt(i));
                    sum = 0;
                }

                for (int j = 0; j < l.length(); j++) {
                    if (sum == j + 1) {
                        result.append(l.charAt(j));
                    }
                }
            }
        }
        return result.toString();
    }
    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();

        String leters = "абвгдеєжзиіїйклмнопрстуфхцчшщьюя";//32
        String Leters = "АБВГДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";//32

        key = key.toLowerCase();

        String p = "";

        key += key.repeat(text.length() / key.length());

        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);

            if (t == '!' || t == '?' || t == '.' || t == ',' || t == '\'' || t == '\n') {
                result.append(t);
            } else {
                String l = "";

                if (isUpperCase(t)) {
                    l = Leters;
                    key = key.toUpperCase();
                } else if (isLowerCase(t)) {
                    l = leters;
                    key = key.toLowerCase();
                }

                int r = 0, x = 0;
                char k = key.charAt(i);

                for (int j = 0; j < l.length(); j++) {
                    if (t == l.charAt(j)) {
                        r = j + 1;
                    }
                }
                for (int j = 0; j < l.length(); j++) {
                    if (k == l.charAt(j)) {
                        x = j + 1;
                    }
                }

                if (t == k) {
                    result.append(" ");
                }
                else {

                    int sum = r - x;
                    if (sum <= 0) {
                        sum = 32 + sum;
                    }

                    for (int j = 0; j < l.length(); j++) {
                        if (sum == j + 1) {
                            p = l.substring(j, j + 1);
                            result.append(p);
                        }

                    }
                }
            }
        }

        return result.toString();
    }
}