package codeforces.problem1;

import java.util.Scanner;

/**
 * Theatre Square
 * <p>
 * Created by Sam on 2016/3/21.
 */
public class ATheatreSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long a = scanner.nextLong();

        System.out.println(
                (n % a == 0 ? n / a : (n / a) + 1) * (m % a == 0 ? m / a : (m / a) + 1)
        );
        scanner.close();
    }
}
