package Lesson5.ProblemH;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        String s = input.nextLine();
        Map<Character, Integer> symbols = new HashMap<>();
        int left = 0, right = 0, maxLength = Integer.MIN_VALUE, index = 0;
        while (left < s.length()) {
            // сначала двигаем правый указатель до того момента
            // пока количество текущего символ не окажется больше чем k
            while (right < s.length()) {
                Character current = s.charAt(right);
                if (symbols.containsKey(current)) {
                    symbols.put(current, symbols.get(current) + 1);
                } else {
                    symbols.put(current, 1);
                }
                // теперь проверяем, не много ли символов
                if (symbols.get(current) > k) {
                    break;
                }
                right++;
            }
            // на данном этапе у нас счётчик right указывает на последнее хорошее число
            // вычисляем текущую длину
            int currentLength = right - left;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                index = left + 1;
            }
            // теперь нам нужно сдвинуть левый указатель, до момента пока текущий символ будет встречаться k или менее раз
            while (left < s.length()) {
                if (symbols.get(s.charAt(left)) > k) {
                    symbols.put(s.charAt(left), symbols.get(s.charAt(left)) - 1);
                    left++;
                    break;
                }
                symbols.put(s.charAt(left), symbols.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        System.out.println(maxLength + " " + index);

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
