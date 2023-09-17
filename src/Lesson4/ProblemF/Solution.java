package Lesson4.ProblemF;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
    static Reader input = new Reader();
    public static void main(String[] args) {
        Map<String , Map<String , Long>> allGoods = new TreeMap<>();
        String s = " ";
        while(true){
            s = input.nextLine();
            if(s == null || s.isEmpty()){
                break;
            }
            update(s , allGoods);
        }
        StringBuilder test = new StringBuilder();
        for (Map.Entry<String, Map<String, Long>> entry1 : allGoods.entrySet()) {
            //System.out.println(entry1.getKey() + ":");
            test.append(entry1.getKey()).append(":").append("\n");
            Map<String , Long> current = entry1.getValue();
            for (Map.Entry<String, Long> entry2 : current.entrySet()) {
                //System.out.println(entry2.getKey() + " " + entry2.getValue());
                test.append(entry2.getKey()).append(" ").append(entry2.getValue()).append("\n");
            }
        }
        System.out.println(test);
    }

    private static void update(String s, Map<String, Map<String, Long>> allGoods) {
        // сначала нужно распарсить
        String[] allVar = s.split(" ");
        String name = allVar[0];
        String nameOfGood = allVar[1];
        Long countOfGood = Long.parseLong(allVar[2]);
        if(allGoods.containsKey(name)){
            // уже имя человека встречалось
            if(allGoods.get(name).containsKey(nameOfGood)){
                allGoods.get(name).put(nameOfGood , allGoods.get(name).get(nameOfGood) + countOfGood);
            }
            else{
                allGoods.get(name).put(nameOfGood , countOfGood);
            }
        }
        else{
            Map<String , Long> current = new TreeMap<>();
            current.put(nameOfGood , countOfGood);
            allGoods.put(name , current);
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
