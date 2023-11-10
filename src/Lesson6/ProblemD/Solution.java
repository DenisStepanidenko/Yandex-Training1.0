package Lesson6.ProblemD;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        long n = input.nextLong();
        long a = input.nextLong();
        long b = input.nextLong();
        long w = input.nextLong();
        long h = input.nextLong();

        long height = Math.max(h, w);
        long width = Math.min(h, w);

        long left = 0;
        long right = height + 1;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (((width / (a + 2 * mid)) * (height / (b + 2 * mid))) >= n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        long maxLeft = left;
        left = 0;
        right = height + 1;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (((width / (b + 2 * mid)) * (height / (a + 2 * mid))) >= n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(Math.max(maxLeft , left));
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
