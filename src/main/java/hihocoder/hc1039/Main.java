package hihocoder.hc1039;

import java.util.Scanner;

/**
 * #1039
 * Created by Sam on 2/13/16.
 */
public class Main {

    final static char[] abc = {'A', 'B', 'C'};
    static StringBuilder stringBridge = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        for (int i = 0; i < lines; i++) {
            String line = scanner.next().trim();
            System.out.println(handleOneLine(line));
        }
    }

    static int handleOneLine(String lineStr) {
        int highestScore = 0;
        int i;
        for (char ch : abc) {
            for (i = 0; i <= lineStr.length(); i++) {
                int score = recurringDeal(newString(lineStr, ch, i));
                if (score > highestScore) {
                    highestScore = score;
                }
            }
        }
        return highestScore;
    }

    static String newString(String origin, char ch, int position) {
        if (position == origin.length()) {
            return origin + ch;
        }
        stringBridge.delete(0, stringBridge.length());
        for (int i = 0; i < origin.length(); i++) {
            if (position == i) {
                stringBridge.append(ch).append(origin.charAt(i));
            } else {
                stringBridge.append(origin.charAt(i));
            }
        }
        return stringBridge.toString();
    }

    static int recurringDeal(String insertString) {
        int score = 0;
        String temp = insertString;
        while (true) {
            AbcOneLineStatistic aols = calcScore(temp);
            if (aols.getSameCount() == 0) {
                break;
            } else {
                score += aols.getSameCount();
                stringBridge.delete(0, stringBridge.length());
                for (int i = 0; i < aols.strLength; i++) {
                    if (aols.statistic[i][0] == 1) {
                        stringBridge.append(temp.charAt(i));
                    }
                }
                temp = stringBridge.toString();
            }
        }
        return score;
    }

    static AbcOneLineStatistic calcScore(String str) {
        AbcOneLineStatistic statistic = new AbcOneLineStatistic(str.length());
        for (int i = 0; i < str.length(); i++) {
            statistic.obtainOneChar(str.charAt(i), i);
        }
        return statistic;
    }

    static class AbcOneLineStatistic {
        int strLength;
        int[][] statistic;
        int verifiedI = -1;
        char lastChar = '0';

        public AbcOneLineStatistic(Integer strLength) {
            this.strLength = strLength;
            statistic = new int[strLength][1];
            for (int i = 0; i < strLength; i++) {
                statistic[i][0] = 0;
            }
        }

        int getSameCount() {
            int count = 0;
            for (int i = 0; i < strLength; i++) {
                count += statistic[i][0] > 1 ? statistic[i][0] : 0;
            }
            return count;
        }

        void obtainOneChar(char ch, int i) {
            if (ch == lastChar) {
                sameOne();
            } else {
                diffOne(i);
                lastChar = ch;
            }
        }

        void diffOne(int i) {
            statistic[i][0] = 1;
            verifiedI = i;
        }

        void sameOne() {
            statistic[verifiedI][0] += 1;
        }
    }
}