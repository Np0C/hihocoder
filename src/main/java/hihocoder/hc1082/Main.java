package hihocoder.hc1082;

import java.util.Scanner;

/**
 * Hihocoder 1082
 * Created by Sam on 3/21/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            int lineLen = line.length();
            if (lineLen < 9) {
                System.out.println(line);
                continue;
            }
            int i = 0;
            char[] chars = line.toCharArray();
            StringBuilder newStringBuffer = new StringBuilder(line.length());
            for (; i < lineLen; ) {
                if (
                        (i + 9 <= lineLen) &&
                                (chars[i] == 'm' || chars[i] == 'M') &&
                                (chars[i + 1] == 'a' || chars[i + 1] == 'A') &&
                                (chars[i + 2] == 'r' || chars[i + 2] == 'R') &&
                                (chars[i + 3] == 's' || chars[i + 3] == 'S') &&
                                (chars[i + 4] == 'h' || chars[i + 4] == 'H') &&
                                (chars[i + 5] == 't' || chars[i + 5] == 'T') &&
                                (chars[i + 6] == 'o' || chars[i + 6] == 'O') &&
                                (chars[i + 7] == 'm' || chars[i + 7] == 'M') &&
                                (chars[i + 8] == 'p' || chars[i + 8] == 'P')
                        ) {
                    newStringBuffer.append("fjxmlhx");
                    i += 9;
                } else {
                    newStringBuffer.append(chars[i]);
                    i++;
                }
            }
            System.out.println(newStringBuffer.toString());
        }
    }
}
