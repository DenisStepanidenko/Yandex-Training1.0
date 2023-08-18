package Lesson2.SymmetricSequence;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            arr[i] = x;
        }
        if (isPalindrom(arr)) {
            System.out.println(0);
        } else {
            for (int i = 0; i < n; i++) {
                int[] arr2 = new int[n - i];
                int count = 0;
                for (int j = i; j < n; j++) {
                    arr2[count] = arr[j];
                    count++;
                }
                boolean flag = isPalindrom(arr2);
                if (flag) {
                    int answer = i;
                    System.out.println(answer);
                    i--;
                    for (int j = i; j >= 0; j--) {
                        System.out.print(arr[j] + " ");
                    }
                    break;
                }
            }
            /*
            int length = 1, i = n - 2;
            boolean flag = true;
            while (flag && i >= 0) {
                int[] arr2 = new int[n - i];
                int count = 0;
                for (int j = n - 1; j >= i; j--) {
                    arr2[count] = arr[j];
                    count++;
                }
                flag = isPalindrom(arr2);
                i--;
            }
            i++;
            int answer = i;
            answer++;
            System.out.println(answer);
            for(int j = i; j >=0; j--){
                System.out.print(arr[j] + " ");
            }

             */
        }
    }

    public static boolean isPalindrom(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    static class Reader extends PrintWriter {

        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
