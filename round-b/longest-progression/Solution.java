import java.util.*;
import java.io.*;

/*
Sliding window


- Assume the first number is the abnormality

    */

public class Solution {

    static boolean debug = true;
    static boolean local = true;

    public static void debug(String s) {
        if (debug) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan;

        if (local) {
            File input = new File("./input.txt");
            scan = new Scanner(input);
        } else {
            scan = new Scanner(System.in);
        }

        int T = scan.nextInt();
        scan.nextLine();
        for (int a = 1; a <= T; a++) {
            String out = solve(scan);
            System.out.println("Case #" + a + ": " + out);
        }

        scan.close();

    }

    public static String solve(Scanner scan) {
        int N = scan.nextInt();
        int[] A = new int[N];

        /*
         * - Calculate the longest run - Change each value to keep the left diff the
         * same and calcualte longest run - Change each value to keep the right diff the
         * same and calcualte longest run
         */

        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        int[][] dp = new int[A.length][2];
        int diff = A[1] - A[0];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = 2;
        dp[1][1] = 2;

        int max = 2;

        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == diff) {
                dp[i][0] = dp[i - 1][0] + 1;
                // if it was already bigger, keep using that value
                dp[i][1] = Math.max(dp[i - 1][1] + 1, dp[i][1]);
            } else {
                if (i + 1 < A.length && ((A[i] - A[i - 1]) + (A[i + 1] - A[i])) / 2 == diff) { // -> keep the count
                    // incrementing
                    dp[i][1] = dp[i - 1][0] + 1;
                    dp[i + 1][1] = dp[i - 1][0] + 2;
                    dp[i + 1][0] = 1;
                    i++;
                } else {
                    // changing this one only adds one more to the chain, make a new diff
                    dp[i][1] = dp[i - 1][0] + 1;
                    diff = A[i] - A[i - 1];
                }
                // if we instead start a new chain on this one
                dp[i][0] = 2;
            }
            max = Math.max(dp[i][0], max);
            max = Math.max(dp[i][1], max);
        }

        diff = A[A.length - 2] - A[A.length - 1];
        int[][] right = new int[A.length][2];
        right[A.length - 1][0] = 1;
        right[A.length - 1][1] = 1;
        right[A.length - 2][0] = 2;
        right[A.length - 2][1] = 2;

        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] - A[i + 1] == diff) {
                right[i][0] = right[i + 1][0] + 1;
                // if it was already bigger, keep using that value
                right[i][1] = Math.max(right[i + 1][1] + 1, right[i][1]);
            } else {
                if (i - 1 >= 0 && ((A[i - 1] - A[i]) + (A[i] - A[i + 1])) / 2 == diff) { // -> keep the count
                    // incrementing
                    right[i][1] = right[i + 1][0] + 1;
                    right[i - 1][1] = right[i + 1][0] + 2;
                    right[i][0] = 1;
                    i--;
                } else {
                    // changing this one only adds one more to the chain, make a new diff
                    right[i][1] = right[i + 1][0] + 1;
                    diff = A[i] - A[i + 1];
                }
                // if we instead start a new chain on this one
                right[i][0] = 2;
            }
            max = Math.max(right[i][0], max);
            max = Math.max(right[i][1], max);
        }

        return max + "";

    }

}