import java.util.*;
import java.io.*;

/*

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
        return "";

    }

}