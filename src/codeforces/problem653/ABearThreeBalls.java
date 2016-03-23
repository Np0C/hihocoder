package codeforces.problem653;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Bear and three balls
 * <p>
 * Created by Sam on 3/23/16.
 */
public class ABearThreeBalls {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ballCount = scanner.nextInt();
        int[] ballArray = new int[ballCount];
        for (int i = 0; i < ballCount; i++) {
            ballArray[i] = scanner.nextInt();
        }
        Arrays.sort(ballArray);
        for (int i = 0; i < ballCount - 1; i++) {
            if ((ballArray[i] + 1 == ballArray[i + 1]) && (ballArray[i + 1] + 1 == ballArray[i + 2])) {
                System.out.println("YES");
                System.exit(1);
            }
        }
        System.out.println("NO");
    }
}
