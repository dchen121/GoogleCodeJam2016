package Qualification;

import java.util.*;
import java.io.*;

public class CountingSheep {

    /**
     * Problem A. Counting Sheep
     *
     * Problem
     *
     * Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster. First, she picks a number N.
     * Then she starts naming N, 2 × N, 3 × N, and so on. Whenever she names a number, she thinks about all of the
     * digits in that number. She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) she has seen at least
     * once so far as part of any number she has named. Once she has seen each of the ten digits at least once, she will
     * fall asleep.
     *
     * Bleatrix must start with N and must always name (i + 1) × N directly after i × N. For example, suppose that
     * Bleatrix picks N = 1692. She would count as follows:
     *      N = 1692. Now she has seen the digits 1, 2, 6, and 9.
     *      2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
     *      3N = 5076. Now she has seen all ten digits, and falls asleep.
     *
     * What is the last number that she will name before falling asleep? If she will count forever, print INSOMNIA instead.
     *
     * Input
     * The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line
     * with a single integer N, the number Bleatrix has chosen.
     *
     * Output
     * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and
     * y is the last number that Bleatrix will name before falling asleep, according to the rules described in the statement.
     *
     * Limits
     * 1 ≤ T ≤ 100.
     *
     * Small dataset
     * 0 ≤ N ≤ 200.
     *
     * Large dataset
     * 0 ≤ N ≤ 106.
     *
     * Sample
     * Input    Output
     * 5        Case #1: INSOMNIA
     * 0        Case #2: 10
     * 1        Case #3: 90
     * 2        Case #4: 110
     * 11       Case #5: 5076
     * 1692
     *
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            Object answer = insomnia(n);

            System.out.println("Case #" + i + ": " + answer);
        }
    }

    /**
     * Return the last number Bleatrix will name before falling asleep. If she will count forever, print INSOMNIA.
     *
     * @param n
     * @return
     */
    private static String insomnia(int n) {
        int[] a = new int[10];
        int currNum;
        int tempNum;

        for (int i = 0; i < 1000; i++) {
            currNum = i*n;
            tempNum = currNum;

            // Record each digit encountered
            while (tempNum > 0) {
                a[tempNum%10] = 1;
                tempNum = tempNum/10;
            }

            if (containsAllOnes(a)) {
                return String.valueOf(currNum);
            }
        }

        return "INSOMNIA";
    }

    /**
     * Returns true if the integer array contains only 1 for each index.
     *
     * @param a
     * @return
     */
    private static boolean containsAllOnes(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
