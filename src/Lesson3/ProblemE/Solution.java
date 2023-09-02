package Lesson3.ProblemE;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        numbers.add(x);
        numbers.add(y);
        numbers.add(z);
        String s = input.nextLine();
        Set<Integer> current = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int m = Integer.parseInt(String.valueOf(s.charAt(i)));
            current.add(m);
        }
        //System.out.println(current);
        int answer = 0;
        for(Integer p : current){
            if(!numbers.contains(p)){
                answer++;
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
