import java.util.*;
import java.io.*;

/*
- Prime Sieve from 1 to sqrt(Z) -> Get all the primes
- Multiply consecutive primes. When you get one that is bigger, stop

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
        int z = scan.nextInt();
        int lastPrime = 0;
        int twoBackPrime = 0;
        Set<Integer> notPrimes = new HashSet<>();
        for (int i = 2; i < Integer.MAX_VALUE; i++) {

            if (notPrimes.contains(i)) {
                notPrimes.remove(i);
                continue;
            }

            // this is a prime number
            if (i * lastPrime > z) {
                debug("Last Prime: " + lastPrime);
                debug("Two Back: " + twoBackPrime);
                return lastPrime * twoBackPrime + "";
            } else {
                twoBackPrime = lastPrime;
                lastPrime = i;
            }

            // Don't need to go all the way to z
            // sqrt(z) may not be high enough -> since one prime can be below the squareroot
            // the other may be above it
            // 40,000 is high enough for 10^9
            for (int j = 2; j * i <= 40000; j++) {
                notPrimes.add(j * i);
            }
        }
        debug("Last Prime: " + lastPrime);
        debug("Two Back: " + twoBackPrime);

        return lastPrime * twoBackPrime + "";

    }

}