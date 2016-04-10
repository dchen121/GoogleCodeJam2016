package Qualification;

import java.util.*;
import java.io.*;

public class CountingSheep {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            Object answer = insomnia(n);

            System.out.println("Case #" + i + ": " + answer);
        }
    }

    private static Object insomnia(int n) {
        int[] a = new int[10];
        int currNum;
        int tempNum;

        for (int i = 0; i < 1000; i++) {
            currNum = i*n;
            tempNum = currNum;

            while (tempNum > 0) {
                a[tempNum%10] = 1;
                tempNum = tempNum/10;
            }

            if (containsAllOnes(a)) {
                return currNum;
            }
        }

        return "INSOMNIA";
    }

    private static boolean containsAllOnes(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
