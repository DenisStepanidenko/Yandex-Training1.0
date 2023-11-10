package Lesson6.ProblemF;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();
    public static void main(String[] args) {

        long N = input.nextLong();
        long x = input.nextLong();
        long y = input.nextLong();
        long left = 1, right = N * Math.max(x, y);
        long time = Math.min(x,y);
        N = N-1;
        if(N != 0) {
            while (left < right) {
                long mid = (left + right) / 2;
                if ((mid / x) + (mid / y) >= N) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(left + time);
        }
        else {
            System.out.println(time);
        }
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
