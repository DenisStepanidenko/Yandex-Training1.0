package Lesson4.ProblemC;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        Map<String, Integer> allWords = new HashMap<>();
        String current = " ";
        while (!current.isEmpty()) {
            current = input.nextLine();
            if (current == null) {
                break;
            }
            update(current, allWords);
        }
        //System.out.println(allWords);
        String maxString = "";
        int maxNumber = -1;
        for (Map.Entry<String, Integer> entry : allWords.entrySet()) {
            String currentWord = entry.getKey();
            int currentCount = entry.getValue();
            if(currentWord.isEmpty()){
                continue;
            }
            if(currentCount > maxNumber){
                maxNumber = currentCount;
                maxString = currentWord;
            }
            else if(currentCount == maxNumber){
                if(currentWord.compareTo(maxString) < 0){
                    maxString = currentWord;
                }
            }
        }
        System.out.println(maxString);
    }

    private static void update(String current, Map<String, Integer> allWords) {
        String[] splitWord = current.trim().split(" ");
        //System.out.println(Arrays.toString(splitWord));
        for (int i = 0; i < splitWord.length; i++) {
            if(allWords.containsKey(splitWord[i])){
                allWords.put(splitWord[i] , allWords.get(splitWord[i]) + 1);
            }
            else{
                allWords.put(splitWord[i] , 1);
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
