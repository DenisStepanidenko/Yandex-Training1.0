package Lesson4.ProblemI;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        //System.out.println("cAnnot".equals("cannOt"));
        Map<String, Set<String>> voc = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String currentWord = input.nextLine();
            String sLow = currentWord.toLowerCase();
            if (voc.containsKey(sLow)) {
                Set<String> current = voc.get(sLow);
                current.add(currentWord);
                voc.put(sLow, current);
            } else {
                Set<String> current = new HashSet<>();
                current.add(currentWord);
                voc.put(sLow, current);
            }
        }
        int answer = 0;
        while(true) {
            String x = input.nextLine();
            if(x == null){
                break;
            }
            if(x.isEmpty()){
                break;
            }
            String[] words = x.split(" ");
            for (int i = 0; i < words.length; i++) {
                String currentWords = words[i];
                String currentLow = currentWords.toLowerCase();
                if (voc.containsKey(currentLow)) {
                    if (!voc.get(currentLow).contains(currentWords)) {
                        //System.out.println(currentWords);
                        answer++;
                    }
                } else {
                    int count = countOfAccent(currentWords);
                    if (count != 1) {
                        answer++;
                        //System.out.println(currentWords);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static int countOfAccent(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(Character.isUpperCase(current)){
                count++;
            }
        }
        return count;
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
