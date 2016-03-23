package codeforces.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * CF-1B SpreadSheet
 * Created by Sam on 2016/3/22.
 */
public class BSpreadSheet {

    static char[] dict = {
            'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y'
    };

    static String QUOTE_C = Pattern.quote("C");
    static String QUOTE_R = Pattern.quote("R");

    public static void main(String[] args) throws Exception {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        StringBuilder result = new StringBuilder(n);
        for (int j = 0; j < n; j++) {
            String line = scanner.readLine();
            char[] chars = line.toCharArray();
            if (chars[0] == 'R' && chars[1] > '0' && chars[1] <= '9' && line.contains("C")) { // gap
                String[] colSplit = line.split(QUOTE_C);
                result.append(convertFromRC(colSplit[0].split(QUOTE_R)[1], colSplit[1]));
            } else {
                int i = 0;
                for (; i < chars.length; ) {
                    if (chars[i] >= '0' && chars[i] <= '9')
                        break;
                    i++;
                }
                result.append(convertFrom26(line.substring(0, i), line.substring(i, line.length())));
            }
            result.append("\n");
        }
        System.out.println(result.toString());
/*
        StringBuilder lOutput = new StringBuilder();
        StringBuilder rowSB = new StringBuilder();
        StringBuilder colSB = new StringBuilder();

        for (String line : lines) {
            char[] chars = line.toCharArray();
            if (chars[0] == 'R') {
                StringBuilder sbPointer = rowSB; // 从前往后遍历
                // 从前往后遍历
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == 'R') {
                        if (sbPointer.length() > 0) {
                            lOutput.append(
                                    convertFromRC(
                                            Integer.parseInt(rowSB.toString()),
                                            Integer.parseInt(colSB.toString())
                                    ));
                            rowSB.delete(0, rowSB.length());
                            colSB.delete(0, colSB.length());
                            sbPointer = rowSB;
                        }
                    }
                    if (chars[i] == 'C') {
                        sbPointer = colSB;
                    }
                    if (chars[i] >= '0' && chars[i] <= '9') {
                        sbPointer.append(chars[i]);
                    }
                }
                lOutput.append(
                        convertFromRC(
                                Integer.parseInt(rowSB.toString()),
                                Integer.parseInt(colSB.toString())
                        ));
            } else {
                StringBuilder sbPointer = colSB; // 从前往后遍历
                char lastChar = '$';
                for (char ch : chars) {
                    if (ch >= 'A' && ch <= 'Z') {
                        if (lastChar >= '0' && lastChar <= '9') {
                            lOutput.append(convertFrom26(colSB.toString(), rowSB.toString()));
                            sbPointer = colSB;
                        }
                    } else {
                        sbPointer = rowSB;
                    }
                    sbPointer.append(ch);
                    lastChar = ch;
                }
                lOutput.append(convertFrom26(colSB.toString(), rowSB.toString()));
            }
            System.out.println(lOutput.toString());
            rowSB.delete(0, rowSB.length());
            colSB.delete(0, colSB.length());
            lOutput.delete(0, lOutput.length());
        }*/

      /*
        for (String line : lines) {
            if (line.startsWith("R")) {
                String[] colSplit = line.split(QUOTE_C);
                System.out.println(convertFromRC(colSplit[0].split(QUOTE_R)[1], colSplit[1]));
            } else {

                char[] chars = line.toCharArray();
                int i = 0;
                for (; i < chars.length; ) {
                    if (chars[i] >= '0' && chars[i] <= '9')
                        break;
                    i++;
                }
                System.out.println(convertFrom26(line.substring(0, i), line.substring(i, line.length())));
            }
        }*/
    }

    public static String convertFromRC(String row, String col) {
        return convertFromRC(Integer.parseInt(row), Integer.parseInt(col));
    }

    public static String convertFromRC(int row, int col) {
        StringBuilder output = new StringBuilder();
        int temp = col;
        while (temp > 0) {
            if (temp <= 26) {
                output.append(octTo26(temp % 26));
                break;
            } else {
                int temp2;
                output.append(octTo26((temp2 = temp % 26)));
                temp /= 26;
                if (temp2 == 0) temp -= 1; // gap
            }
        }
        return output.reverse().toString() + row;
    }

    public static String convertFrom26(String col, String row) {
        char[] colChar = col.toCharArray();
        int octColValue = 0;
        int colCharLen = colChar.length;
        for (int i = colCharLen - 1; i >= 0; i--) {
            octColValue += toIndex(colChar[i]) * Math.pow(26, colCharLen - i - 1);
        }
        return "R" + row + "C" + octColValue;
    }

    static char octTo26(int oct) {
        return dict[oct];
    }

    static int toIndex(char ch) {
        return ch == 'A' ? 1 : ch == 'B' ? 2 : ch == 'C' ? 3 : ch == 'D' ? 4
                : ch == 'E' ? 5 : ch == 'F' ? 6 : ch == 'G' ? 7 : ch == 'H' ? 8
                : ch == 'I' ? 9 : ch == 'J' ? 10 : ch == 'K' ? 11 : ch == 'L' ? 12
                : ch == 'M' ? 13 : ch == 'N' ? 14 : ch == 'O' ? 15 : ch == 'P' ? 16
                : ch == 'Q' ? 17 : ch == 'R' ? 18 : ch == 'S' ? 19 : ch == 'T' ? 20
                : ch == 'U' ? 21 : ch == 'V' ? 22 : ch == 'W' ? 23 : ch == 'X' ? 24
                : ch == 'Y' ? 25 : ch == 'Z' ? 26 : -1;
    }
}
