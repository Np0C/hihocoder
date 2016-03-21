package hihocoder.hc1051;

import java.util.Scanner;

/**
 * 1051
 * Created by Sam on 2/13/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupCount = scanner.nextInt();
        for (int i = 0; i < groupCount; i++) {
            String group1stLine = scanner.nextLine();
            String group2ndLine = scanner.nextLine();

            String[] firstLineSplit = group1stLine.split("\\s");
            int missed = Integer.parseInt(firstLineSplit[0]);
            int antiMissed = Integer.parseInt(firstLineSplit[1]);
            if (antiMissed >= missed) {
                System.out.println(100);
            } else {
                String[] secondLineSplit = group2ndLine.split("\\s");
                int[] missedDays = new int[missed];
                for (int j = 0; j < missed; j++) {
                    (missedDays[j] = Integer.parseInt(secondLineSplit[j]);
                }
            }




        }
    }
}
