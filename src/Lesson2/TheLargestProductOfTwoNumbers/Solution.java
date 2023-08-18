package Lesson2.TheLargestProductOfTwoNumbers;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        String[] s = input.nextLine().split(" ");
        long[] arr = toArray(s);
        /*
         * нужно хранить максимальное положительное и предмаксимальное положительное число
         * также нужно хранить минимальное отрицательное число и предминимальное отрицательное число
         */
        if(arr.length == 2){
            System.out.println(Math.min(arr[0] , arr[1]) + " " + Math.max(arr[0] , arr[1]));
            System.exit(0);
        }
        long max1Pos = 0, max2Pos = 0; // для положительных
        long min1Neg = 0, min2Neg = 0; // для отрицательных
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (arr[i] > max1Pos) {
                    max2Pos = max1Pos;
                    max1Pos = arr[i];
                } else {
                    if (arr[i] > max2Pos) {
                        max2Pos = arr[i];
                    }
                }
            } else if (arr[i] < 0) {
                if (arr[i] < min1Neg) {
                    min2Neg = min1Neg;
                    min1Neg = arr[i];
                } else {
                    if (arr[i] < min2Neg) {
                        min2Neg = arr[i];
                    }
                }
            }
        }
        if (max1Pos * max2Pos > min1Neg * min2Neg) {
            System.out.println(Math.min(max2Pos, max1Pos) + " " + Math.max(max2Pos, max1Pos));
        }
        else{
            System.out.println(Math.min(min2Neg, min1Neg) + " " + Math.max(min2Neg, min1Neg));
        }

    }

    public static long[] toArray(String[] s) {
        long[] arr = new long[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Long.parseLong(s[i]);
        }
        return arr;
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
