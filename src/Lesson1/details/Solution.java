package Lesson1.details;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        int m = input.nextInt();
        int answer = 0;
        while (n > 0) {
            int countOfBlanks = (int) Math.floor(n / (double) k); // количество заготовок
            if (countOfBlanks == 0) {
                break;
            }
            n -= countOfBlanks * k; // осталось всего сплава изначального
            int countOfDetails = (int) ((Math.floor(k / (double) m)) * countOfBlanks);
            if (countOfDetails == 0) {
                break;
            }
            answer += countOfDetails; // прибавили к ответу количество деталей
            int weightOfBlanks = (int) ((k - (Math.floor(k / (double) m)) * m) * countOfBlanks); // столько осталось кг
            if (weightOfBlanks <= 0) {
                break;
            } else {
                n += weightOfBlanks;
            }
        }
        System.out.println(answer);
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
