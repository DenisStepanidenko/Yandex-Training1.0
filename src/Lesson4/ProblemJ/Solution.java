package Lesson4.ProblemJ;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        String test = "9";
        // латинские буквы, цифры, знаки подчёркивания
        // не должны являться ключевыми
        // цифра не идентификатор
        Set<String> keyWords = new HashSet<>();
        int n = input.nextInt();
        String isSensitive1 = input.next();
        String isNumber1 = input.next();
        boolean isSensitive, isNumber;
        isSensitive = isSensitive1.equals("yes");
        isNumber = isNumber1.equals("yes");
        int allCount = 1;
        for (int i = 0; i < n; i++) {
            String currentKey = input.nextLine().trim();
            currentKey = isSensitive ? currentKey : currentKey.toLowerCase();
            keyWords.add(currentKey);
        }

        // заполнили множество ключевых слов
        long max = -1;
        String answerMax = " ";
        Map<String, Integer> allIdentity = new HashMap<>();
        Map<String , Integer> firstMention = new HashMap<>();
        String s = " ";
        while (true) {
            s = input.nextLine();
            if (s == null || s.isEmpty()) {
                break;
            }
            StringBuilder currentWords = new StringBuilder();
            int k = 0;
            for (int i = 0; i < s.length(); i++) {
                Character y = s.charAt(i);
                if ((Character.isLetter(y) || Character.isDigit(y) || y.equals('_'))) {
                    currentWords.append(y);
                    k++;
                } else {
                    currentWords.append(" ");
                }
            }
            if (k == 0) {

            } else {
                String[] words = currentWords.toString().trim().split(" +");
                //System.out.println(Arrays.toString(words));
                //System.out.println(Arrays.toString(words));
                for (int i = 0; i < words.length; i++) {
                    String currentWord = words[i];
                    // сначала проверим, что это не цифра
                    if (currentWord.length() == 1) {
                        if (Character.isDigit(currentWord.charAt(0))) {
                            continue;
                        }
                    }
                    // проверим не является ли это ключевым словом
                    if (isSensitive) {
                        if (keyWords.contains(currentWord)) {
                            continue;
                        }
                    } else {
                        if (keyWords.contains(currentWord.toLowerCase())) {
                            continue;
                        }
                    }
                    // проверим, может ли начинаться с цифры
                    if (!isNumber) {
                        if (Character.isDigit(currentWord.charAt(0))) {
                            continue;
                        }
                    }
                    // на данном этапе мы знаем, что это точно идентификатор
                    if(isSensitive) {
                        if (allIdentity.containsKey(currentWord)) {
                            allIdentity.put(currentWord, allIdentity.get(currentWord) + 1);
                            allCount++;
                            if (allIdentity.get(currentWord) > max) {
                                max = allIdentity.get(currentWord);
                                answerMax = currentWord;
                            }
                            else if(allIdentity.get(currentWord) == max){
                                if(firstMention.get(currentWord) < firstMention.get(answerMax)){
                                    answerMax = currentWord;
                                }
                            }
                        } else {
                            allIdentity.put(currentWord, 1);
                            firstMention.put(currentWord , allCount);
                            allCount++;
                            if (1 > max) {
                                max = allIdentity.get(currentWord);
                                answerMax = currentWord;
                            }
                            else if(allIdentity.get(currentWord) == max){
                                if(firstMention.get(currentWord) < firstMention.get(answerMax)){
                                    answerMax = currentWord;
                                }
                            }
                        }
                    }
                    else{
                        if (allIdentity.containsKey(currentWord.toLowerCase())) {
                            allIdentity.put(currentWord.toLowerCase(), allIdentity.get(currentWord.toLowerCase()) + 1);
                            allCount++;
                            if (allIdentity.get(currentWord.toLowerCase()) > max) {
                                max = allIdentity.get(currentWord.toLowerCase());
                                answerMax = currentWord.toLowerCase();
                            }
                            else if(allIdentity.get(currentWord.toLowerCase()) == max){
                                if(firstMention.get(currentWord.toLowerCase()) < firstMention.get(answerMax)){
                                    answerMax = currentWord.toLowerCase();
                                }
                            }
                        } else {
                            allIdentity.put(currentWord.toLowerCase(), 1);
                            firstMention.put(currentWord.toLowerCase() , allCount);
                            allCount++;
                            if (1 > max) {
                                max = allIdentity.get(currentWord.toLowerCase());
                                answerMax = currentWord.toLowerCase();
                            }
                            else if(allIdentity.get(currentWord.toLowerCase()) == max){
                                if(firstMention.get(currentWord.toLowerCase()) < firstMention.get(answerMax)){
                                    answerMax = currentWord.toLowerCase();
                                }
                            }
                        }
                    }

                }
            }
        }
        //System.out.println(allIdentity);
        System.out.println(answerMax);
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
