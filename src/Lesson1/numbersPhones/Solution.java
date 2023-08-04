package Lesson1.numbersPhones;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        String s = input.nextLine();
        StringBuilder sOnlyNubmers = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sOnlyNubmers.append(s.charAt(i));
            }
        }
        String sNew = sOnlyNubmers.toString();
        String code = "";
        String number = "";
        if (sNew.length() == 7) {
            code = "495";
            number = sNew;
        } else {
            code = sNew.substring(1, 4);
            number = sNew.substring(4);
        }
        for (int i = 0; i < 3; i++) {
            String p = input.nextLine();
            StringBuilder currentLine = new StringBuilder();
            for (int j = 0; j < p.length(); j++) {
                if (Character.isDigit(p.charAt(j))) {
                    currentLine.append(p.charAt(j));
                }
            }
            String currentLineString = currentLine.toString();
            String currentCode = "";
            String currentNumber = "";
            if (currentLineString.length() == 7) {
                currentCode= "495";
                currentNumber = currentLineString;
            } else {
                currentCode= currentLineString.substring(1, 4);
                currentNumber = currentLineString.substring(4);
            }
            if(code.equals(currentCode) && number.equals(currentNumber)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
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
