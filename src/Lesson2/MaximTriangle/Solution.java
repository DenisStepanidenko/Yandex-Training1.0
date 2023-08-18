package Lesson2.MaximTriangle;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        double left = 30, right = 4000;
        double previous = 0, current = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                double x = input.nextDouble();
                current = x;
                continue;
            }
            double x = input.nextDouble();
            String s = input.next();
            previous = current;
            current = x;
            if (s.equals("closer")) {
                if (current - previous > 0) {
                    double leftBorder = (previous + current) / 2;
                    left = Math.max(left, leftBorder);
                } else {
                    double rightBorder = (previous + current) / 2;
                    right = Math.min(right , rightBorder);
                }
            }
            else{
                if (current - previous > 0) {
                    double rightBorder = (previous + current) / 2;
                    right = Math.min(right, rightBorder);
                } else {
                    double leftBorder = (previous + current) / 2;
                    left = Math.max(left , leftBorder);
                }
            }

        }
        System.out.println(left + " " + right);
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
