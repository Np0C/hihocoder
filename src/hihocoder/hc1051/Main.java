package hihocoder.hc1051;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 1051
 * Created by Sam on 2/13/16.
 */
public class Main {
    static String BLANK_QUOTE = Pattern.quote(" ");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int items = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < items; i++) {
            String item1stLine = scanner.nextLine().trim();
            String item2ndLine = scanner.nextLine().trim();

            String[] firstLineSplit = item1stLine.split(BLANK_QUOTE);
            int missedDayCount = Integer.parseInt(firstLineSplit[0]);
            int fetchCardCount = Integer.parseInt(firstLineSplit[1]);

            // 以下几种情况连续天数是100
            // 1.补提交卡数量大于等于漏掉的天数
            // 2.漏掉的天数是0，
            if (fetchCardCount >= missedDayCount || missedDayCount == 0) {
                System.out.println(100);
            } else {
                String[] missedDayChars = item2ndLine.split(BLANK_QUOTE);
                int[] missedDays = new int[missedDayCount];
                for (int j = 0; j < missedDayCount; j++) {
                    missedDays[j] = Integer.parseInt(missedDayChars[j]);
                }
                int largest = 0;
                int temp;
                for (int k = 0; k < missedDayCount - fetchCardCount; k++) {
                    if (k == 0) {
                        temp = missedDays[fetchCardCount] - 1;
                        largest = temp > largest ? temp : largest;
                    } else if (k == (missedDayCount - fetchCardCount)) {
                        temp = 100 - missedDays[k - 1];
                        largest = temp > largest ? temp : largest;
                    } else {
                        temp = missedDays[k + fetchCardCount] - missedDays[k - 1] - 1;
                        largest = temp > largest ? temp : largest;
                    }
                }
                System.out.println(largest);
            }
        }
    }
}