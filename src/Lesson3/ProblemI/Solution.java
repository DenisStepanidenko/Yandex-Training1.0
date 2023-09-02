package Lesson3.ProblemI;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        Map<String, Integer> answers = new HashMap<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int m = input.nextInt();
            for (int j = 0; j < m; j++) {
                String current = input.nextLine();
                if (answers.containsKey(current)) {
                    answers.put(current, answers.get(current) + 1);
                } else {
                    answers.put(current, 1);
                }
            }
        }
        List<String> all = new ArrayList<>();
        List<String> others = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : answers.entrySet()) {
            int value = entry.getValue();
            if (value == n) {
                all.add(entry.getKey());
                others.add(entry.getKey());
            } else {
                others.add(entry.getKey());
            }
        }
        System.out.println(all.size());
        for (String s : all) {
            System.out.println(s);
        }
        System.out.println(others.size());
        for (String s : others) {
            System.out.println(s);
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
