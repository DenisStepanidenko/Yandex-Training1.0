package Lesson4.ProblemG;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Solution {
    static Reader input = new Reader();
    public static void main(String[] args) {
        Map<String , Long> allClients = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        String s = " ";
        while(true){
            s = input.nextLine();
            if(s == null || s.isEmpty()){
                break;
            }
            update(s , allClients , answer);
        }
        System.out.println(answer);
    }

    private static void update(String s, Map<String, Long> allClients , StringBuilder answer) {
        String[] allVar = s.split(" ");
        String first = allVar[0];
        if(first.equals("DEPOSIT")){
            String name = allVar[1];
            Long sum = Long.parseLong(allVar[2]);
            if(allClients.containsKey(name)){
                allClients.put(name , allClients.get(name) + sum);
            }
            else{
                allClients.put(name , sum);
            }
        }
        else if(first.equals("WITHDRAW")){
            String name = allVar[1];
            Long sum = Long.parseLong(allVar[2]);
            if(allClients.containsKey(name)){
                allClients.put(name , allClients.get(name) - sum);
            }
            else{
                allClients.put(name , sum * (-1));
            }
        }
        else if(first.equals("BALANCE")){
            String name = allVar[1];
            if(allClients.containsKey(name)){
                answer.append(allClients.get(name)).append("\n");
            }
            else{
                answer.append("ERROR").append("\n");
            }
        }
        else if(first.equals("TRANSFER")){
            String nameOf = allVar[1];
            String nameTo = allVar[2];
            Long sum = Long.parseLong(allVar[3]);
            if(allClients.containsKey(nameOf)){
                allClients.put(nameOf , allClients.get(nameOf) - sum);
            }
            else{
                allClients.put(nameOf , sum * (-1));
            }

            if(allClients.containsKey(nameTo)){
                allClients.put(nameTo , allClients.get(nameTo) + sum);
            }
            else{
                allClients.put(nameTo , sum);
            }
        }
        else{
            Long procent = Long.parseLong(allVar[1]);
            for (Map.Entry<String, Long> entry : allClients.entrySet()) {
                if(entry.getValue() <= 0){
                    continue;
                }
                Long plus = (entry.getValue() * procent) / 100;
                entry.setValue(entry.getValue() + plus);
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
