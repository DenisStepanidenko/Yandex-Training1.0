package Lesson5.ProblemG;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        Map<Long, Long> numbers = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            // считываем информацию
            long x = input.nextLong();
            if (numbers.containsKey(x)) {
                numbers.put(x, numbers.get(x) + 1);
            } else {
                numbers.put(x, 1L);
            }
        }

        // создаём список ключей, именно список, так как нам нужно использовать два указателя
        Set<Long> keysSet = numbers.keySet();
        List<Long> keysList = new ArrayList<>(keysSet);
        //System.out.println(keysList);
        long left = 0,  right = 0;
        long answer = 0;
        int count = 0; // количество тех чисел, которые встречаются два или более раз
        while (left < keysList.size()) {
            while (right < keysList.size() && (keysList.get((int) right) <= (keysList.get((int) left) * k))) {
                if (numbers.get(keysList.get((int) right)) >= 2) {
                    count++;
                }
                right++;
            }

            // сейчас right находится на самом первом плохом числе , где отношение больше чем k
            // теперь нужно посчитать количество способов
            // сначала считаем количество способов выбрать первый элемент - left , второй и третий из R-L
            answer += 3 * (((long) (right - left - 1) * (right - left - 2)));
            // посчитаем количество способов, когда у нас элемента left встречается два раза
            if (numbers.get(keysList.get((int) left)) >= 2) {
                answer += (right - left - 1) * 3L;
            }
            // посчитаем способ, когда все числа в тройке - равны left
            if (numbers.get(keysList.get((int) left)) >= 3) {
                answer += 1;
            }

            // посчитаем количество способ, когда один элемент left , а два других равны друг другу и отличаются от left
            if(numbers.get(keysList.get((int) left)) >= 2){
                count--;
            }
            answer += count * 3L;
            left++;
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
