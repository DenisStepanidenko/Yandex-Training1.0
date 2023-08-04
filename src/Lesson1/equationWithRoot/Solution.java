package Lesson1.equationWithRoot;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        System.out.println(Math.floor(0.0000001));
        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();

        if (c < 0) {
            System.out.println("NO SOLUTION");
        } else {
            if (a != 0) {
                if ((Math.pow(c, 2) - b) % a == 0) {
                    long answer = (long) ((Math.pow(c, 2) - b) / a);
                    System.out.println(answer);
                } else {
                    System.out.println("NO SOLUTION");
                }
            } else {
                if ((Math.pow(c, 2) - b) == 0) {
                    System.out.println("MANY SOLUTIONS");
                } else {
                    System.out.println("NO SOLUTION");
                }
            }
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
