package Lesson6.ProblemE;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        //System.out.println(result(999999999999998L, 1000000000000000L, 1000000000000000L, 1000000000000000L));
        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();
        long left = 0, right = a + b + c;
        long sum = 2 * a + 3 * b + 4 * c;
        // сделаем бин поиск
        while (left < right) {
            long mid = (left + right) / 2;
            if((sum + 5 * mid ) * 2 < 7 * (mid + (a+b+c))){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        System.out.println(left);
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
