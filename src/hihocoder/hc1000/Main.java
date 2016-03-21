package hihocoder.hc1000;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * hihocoder #hc1000
 * Created by Sam on 2/12/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<MyNumbers> myNumberses = readSystemInNumbers();
        for (MyNumbers myNumbers : myNumberses) {
            bw.write(String.valueOf(myNumbers.a + myNumbers.b));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class MyNumbers {
        int a = 0;
        int b = 0;
    }

    static List<MyNumbers> readSystemInNumbers() throws Exception {
        List<MyNumbers> list = new ArrayList<>();
        MyScanner scanner = new MyScanner();
        while (scanner.hasNext()) {
            MyNumbers mn = new MyNumbers();
            mn.a = scanner.nextInt();
            mn.b = scanner.nextInt();
            list.add(mn);
        }
//        scanner.close();
        return list;
    }

    static class MyScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public MyScanner(String path) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(path)));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        boolean hasNext() {
            if (st != null && st.hasMoreElements())
                return true;

            try {
                while (st == null || !st.hasMoreElements())
                    st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return false;
            }

            return true;
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        String[] nextStrings(int n) throws IOException {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++)
                arr[i] = next();
            return arr;
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        int[] nextInts(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        void nextInts(int[] arr, int from, int to) throws IOException {
            for (int i = from; i < to; i++)
                arr[i] = nextInt();
        }

        int[][] next2Ints(int n, int m) throws IOException {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        long[] nextLongs(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
            return arr;
        }

        void nextLongs(long[] arr, int from, int to) throws IOException {
            for (int i = from; i < to; i++)
                arr[i] = nextLong();
        }

        long[][] next2Longs(int n, int m) throws IOException {
            long[][] arr = new long[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextLong();
            return arr;
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next().replace(',', '.'));
        }

        double[] nextDoubles(int size) throws IOException {
            double[] arr = new double[size];
            for (int i = 0; i < size; i++)
                arr[i] = nextDouble();
            return arr;
        }

        boolean nextBool() throws IOException {
            String s = next();
            if (s.equalsIgnoreCase("true") || s.equals("1"))
                return true;

            if (s.equalsIgnoreCase("false") || s.equals("0"))
                return false;

            throw new IOException("Boolean expected, String found!");
        }
    }

}
