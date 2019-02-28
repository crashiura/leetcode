package com.crashiura.leecode.t8_string_to_integer;

public class Main {
    public static void main(String[] args) {
        System.out.println(myAtoi("45"));
    }

    public static int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int i = 0;
        int sing = 0;
        boolean isNegative = false;

        while (i < str.length()) {
            char c1 = str.charAt(i);

            if (sing == 0 && c1 == ' ') {
            } else if (sing == 0 && (c1 == '-' || c1 == '+')) {
                sing++;
                isNegative = c1 == '-';
            } else if (c1 < '0' || c1 > '9') {
                return 0;
            } else {
                break;
            }

            i++;
        }

        int result = 0;
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }

            int c2 = str.charAt(i) - '0';
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && c2 > Integer.MAX_VALUE % 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + c2;
            i++;
        }

        return isNegative ? -result : result;
    }
}
