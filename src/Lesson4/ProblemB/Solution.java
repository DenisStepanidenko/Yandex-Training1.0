package Lesson4.ProblemB;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        String s = " ";
        Map<String, Integer> allWords = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        while (!s.isEmpty()) {
            s = input.nextLine();
            if (s == null) {
                break;
            }
            currentLine(s, allWords, answer);
        }
        System.out.println(answer);
    }

    private static void currentLine(String s, Map<String, Integer> allWords, StringBuilder answer) {
        StringBuilder current = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char currentSymbol = s.charAt(i);
            if (currentSymbol == ' ') {
                if (flag) {
                    String currentWord = current.toString();
                    if (allWords.containsKey(currentWord)) {
                        answer.append(allWords.get(currentWord)).append(" ");
                        //System.out.println(allWords.get(currentWord));
                        allWords.put(currentWord, allWords.get(currentWord) + 1);
                    }
                    else{
                        answer.append(0).append(" ");
                        //System.out.println(0);
                        allWords.put(currentWord , 1);
                    }
                    flag = false;
                    current = new StringBuilder();
                }
            }
            else{
                if(!flag){
                    flag = true;
                }
                current.append(currentSymbol);
                if(i == (s.length() - 1)){
                    String currentWord = current.toString();
                    if (allWords.containsKey(currentWord)) {
                        answer.append(allWords.get(currentWord)).append(" ");
                        //System.out.println(allWords.get(currentWord));
                        allWords.put(currentWord, allWords.get(currentWord) + 1);
                    }
                    else{
                        answer.append(0).append(" ");
                        //System.out.println(0);
                        allWords.put(currentWord , 1);
                    }
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
