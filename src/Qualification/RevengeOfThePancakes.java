package Qualification;

import java.util.*;
import java.io.*;

/**
 * Created by Daniel on 2016-04-09.
 */
public class RevengeOfThePancakes {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            int flips = countFlipsPlus(s, 0);
            System.out.println("Case #" + i + ": " + (flips));
        }
    }

    private static int countFlipsPlus(String s, int count) {
        if (s.length() == 0) {
            return count;
        }

        else if (s.length() == 1) {
            if (s.equals("+")) {
                return count;
            } else {
                return count+1;
            }
        }

        else if (allDash(s)) {
            return count+1;
        }

        else if (s.substring(s.length()-1,s.length()).equals("+")) {
            return countFlipsPlus(s.substring(0, s.length()-1), count);
        }

        else if (s.substring(0, 1).equals("-") && s.substring(s.length()-1, s.length()).equals("-")) {
            String newStr = reverseAndFlip(s);
            return countFlipsPlus(newStr, count+1);
        }

        else {
            return 1 + countFlipsDash(s, count);
        }
    }

    private static int countFlipsDash(String s, int count) {
        if (s.length() == 0) {
            return count;
        }

        else if (s.length() == 1) {
            if (s.equals("-")) {
                return count;
            } else {
                return count+1;
            }
        }

        else if (allPlus(s)) {
            return count+1;
        }

        else if (s.substring(s.length()-1,s.length()).equals("-")) {
            return countFlipsDash(s.substring(0, s.length()-1), count);
        }

        else if (s.substring(0, 1).equals("+") && s.substring(s.length()-1, s.length()).equals("+")) {
            String newStr = reverseAndFlip(s);
            return countFlipsDash(newStr, count+1);
        }

        else {
            return 1 + countFlipsPlus(s, count);
        }
    }

    private static boolean allPlus(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!s.substring(i, i+1).equals("+")) {
                return false;
            }
        }

        return true;
    }

    private static boolean allDash(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!s.substring(i, i+1).equals("-")) {
                return false;
            }
        }

        return true;
    }

    private static String reverseAndFlip(String s) {
        String newStr = new StringBuilder(s).reverse().toString();
        newStr = newStr.replace("+", "1");
        newStr = newStr.replace("-", "+");
        newStr = newStr.replace("1", "-");
        return newStr;
    }
}