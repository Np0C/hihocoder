package codeforces.problem653;

import java.util.*;

/**
 * Bear and three balls
 * <p>
 * Created by Sam on 3/23/16.
 */
public class ABearThreeBalls {

    public static void main(String[] args) {

        /**
         * 读取系统输入时就进行排序
         */
        /*
        Scanner scanner = new Scanner(System.in);
        int ballCount = scanner.nextInt();

        Set<Integer> ballSet = new TreeSet<>();
        for (int i = 0; i < ballCount; i++) {
            ballSet.add(scanner.nextInt());
        }
        Integer[] ballArray = ballSet.toArray(new Integer[1]);
        for (int i = 0; i < ballArray.length - 2; i++) {
            if ((ballArray[i] + 1 == ballArray[i + 1]) && (ballArray[i + 1] + 1 == ballArray[i + 2])) {
                System.out.println("YES");
                System.exit(0);
            }
        }
        System.out.println("NO");
        */


        /**
         * 把系统输入都读出来,然后再使用快速排序进行排序.
         * 讲 TreeSet 换成不排序的HashSet,读取输入时仅仅做一次去重
         */
        Scanner scanner = new Scanner(System.in);
        int ballCount = scanner.nextInt();

        Set<Integer> ballSet = new TreeSet<>();
        for (int i = 0; i < ballCount; i++) {
            ballSet.add(scanner.nextInt());
        }
        Integer[] ballArray = ballSet.toArray(new Integer[1]);
        //Arrays.sort(ballArray);
        for (int i = 0; i < ballArray.length - 2; i++) {
            if ((ballArray[i] + 1 == ballArray[i + 1]) && (ballArray[i + 1] + 1 == ballArray[i + 2])) {
                System.out.println("YES");
                System.exit(0);
            }
        }
        System.out.println("NO");
    }
}
