package Lesson2.TheLargestProductOfThreeNumbers;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        String[] s = input.nextLine().split(" ");
        long[] arr = toArray(s);
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max3 = max2;
                max2 = arr[i];
            } else if (arr[i] > max3) {
                max3 = arr[i];
            }
            if(arr[i] < min1) {
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2) {
                min2 = arr[i];
            }
        }
        if (max1 * max2 * max3 > min1 * min2 * max1) {
            System.out.println(max1 + " " + max2 + " " + max3);
        } else {
            System.out.println(min1 + " " + min2 + " " + max1);
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
