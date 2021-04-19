import java.util.*;
import java.io.*;

/*
Could try to replace all ? with a C,
all with a J
2^T

If we can keep it the same letter, no cost
??C -> No Cost
C?? -> NO Cost

Only care when ? is sandwiched between C and J... we have to make a choice

J?C
JJC
JCC
- Even when sandwiched, will always have a single JC

CJ - X
JC - Y

- If ? dangling, delete
- If Sandwhiched, delete


*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("/home/macolby14/kickstart/input.txt");
        Scanner scan = new Scanner(input);

        // Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        for (int a = 1; a <= T; a++) {
            String out = solve(scan);
            System.out.println("Case #" + a + ": " + out);
        }

        scan.close();

    }

    public static String solve(Scanner scan) {
        int X = scan.nextInt();
        int Y = scan.nextInt();
        String in = scan.nextLine().trim();
        int cost = 0;

        String noQuest = in.replace("?", "");

        for (int i = 0; i < noQuest.length() - 1; i++) {
            String sub = noQuest.substring(i, i + 2);
            if (sub.equals("JC")) {
                cost += Y;
            }
            if (sub.equals("CJ")) {
                cost += X;
            }
        }

        return cost + "";
    }

}
