package Lesson4.ProblemH;

import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int g = input.nextInt();
        int sLength = input.nextInt();
        String w = input.nextLine();
        String s = input.nextLine();
        int lenW = w.length();
        int answer = 0;
        Map<Character, Integer> wSymbols = new HashMap<>();
        Map<Character, Integer> currentSeq = new HashMap<>();
        for (int i = 0; i < w.length(); i++) {
            Character current = w.charAt(i);
            updateMap(current, wSymbols);
        }
        int count = 0;
        int coincidences = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i + 1) == lenW) {
                Character current = s.charAt(i);
                updateMap(current, currentSeq);
                coincidences = check(wSymbols, currentSeq);
                if (coincidences == wSymbols.size() && coincidences == currentSeq.size()) {
                    answer++;
                }
            } else if ((i + 1) < lenW) {
                Character current = s.charAt(i);
                updateMap(current, currentSeq);
            } else {
                Character current = s.charAt(i);
                if (currentSeq.get(s.charAt(count)) - 1 == 0) {
                    if(wSymbols.containsKey(s.charAt(count))){
                        if(wSymbols.get(s.charAt(count)) == 1) {
                            coincidences--;
                        }
                    }
                    currentSeq.remove(s.charAt(count));
                } else {
                    currentSeq.put(s.charAt(count), currentSeq.get(s.charAt(count)) - 1);
                    if (wSymbols.containsKey(s.charAt(count))) {
                        if ( (currentSeq.get(s.charAt(count))) == wSymbols.get(s.charAt(count))) {
                            coincidences++;
                        }
                        else{
                            if(currentSeq.get(s.charAt(count)) + 1 == wSymbols.get(s.charAt(count))) {
                                coincidences--;
                            }
                        }
                    }
                }
                count++;
                updateMap(current, currentSeq);
                if (wSymbols.containsKey(current)) {
                    if (wSymbols.get(current) == currentSeq.get(current)) {
                        coincidences++;
                    } else {
                        if(currentSeq.get(current) == wSymbols.get(current) + 1) {
                            coincidences--;
                        }
                    }
                }
//                System.out.println(i + " "+ coincidences);
//                if(i == 13 || i == 10){
//                    System.out.println(currentSeq);
//                }
                if (coincidences == wSymbols.size() && coincidences == currentSeq.size()) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static int check(Map<Character, Integer> wSymbols, Map<Character, Integer> currentSeq) {
        int currentCount = 0;
        for (Map.Entry<Character, Integer> entry : wSymbols.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (currentSeq.containsKey(key)) {
                if (currentSeq.get(key) == value) {
                    currentCount++;
                }
            }
        }
        return currentCount;
    }

    public static void updateMap(Character x, Map<Character, Integer> currentSeq) {
        if (currentSeq.containsKey(x)) {
            currentSeq.put(x, currentSeq.get(x) + 1);
        } else {
            currentSeq.put(x, 1);
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
