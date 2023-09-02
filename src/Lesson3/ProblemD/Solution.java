package Lesson3.ProblemD;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        //System.out.println(System.lineSeparator());
        String s = " ";
        long answer = 0;
        Set<String> allWords = new HashSet<>();
        while (!s.isEmpty()) {
            s = input.nextLine();
            if(s == null){
                break;
            }
            answer += update(s,  allWords);
        }
        //System.out.println(allWords);
        System.out.println(answer);
    }

    public static long update(String s, Set<String> allWords) {
        long answer = 0;
        boolean flag = false;
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentSymbol = s.charAt(i);
            if (currentSymbol == ' ') {
                if (flag) {
                    String newString = current.toString();
                    if (!allWords.contains(newString)) {
                        answer++;
                        allWords.add(newString);
                        //System.out.println(newString);
                    }
                    current = new StringBuilder();
                    flag = false;
                }
            } else {
                if (!flag) {
                    flag = true;
                }
                current.append(currentSymbol);
                if (i == (s.length() - 1)) {
                    String newString = current.toString();
                    if (!allWords.contains(newString)) {
                        answer++;
                        allWords.add(newString);
                        //System.out.println(newString);
                    }
                }
            }
        }
        return answer;
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
