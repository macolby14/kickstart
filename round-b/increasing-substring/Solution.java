import java.util.*;
import java.io.*;

/*

*/

public class Solution {

    static boolean debug = false;
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
        scan.nextLine();
        String s = scan.nextLine();

        int[] inc = new int[N];
        inc[0] = 1;
        char maxChar = s.charAt(0);

        int currInc = 1;

        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            debug("curr: " + currChar);
            debug("max: " + maxChar);
            debug("" + (maxChar > currChar));
            if (currChar > maxChar) {
                currInc++;
            } else {
                currInc = 1;
            }

            maxChar = currChar;
            inc[i] = currInc;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : inc) {
            sb.append(i + " ");
        }

        return sb.toString().trim();

    }

}