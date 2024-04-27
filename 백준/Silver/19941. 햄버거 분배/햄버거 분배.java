
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        char[] ham = br.readLine().toCharArray();
        ArrayList<Integer> person = new ArrayList<>();
        ArrayList<Integer> hamburger = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(ham[i] =='H') hamburger.add(i);
            else person.add(i);
        }
        visited = new boolean[hamburger.size()];
        int cnt = 0;
        for (int i = 0; i < person.size(); i++) {
            int per = person.get(i);
            for (int j = 0; j < hamburger.size(); j++) {
                int hamIdx = hamburger.get(j);
                if (!visited[j] && Math.abs(per -hamIdx) <= K) {
                    visited[j] = true;
                    cnt++;
                    break;
                }
            }
        }




        System.out.println(cnt);

    }
}
