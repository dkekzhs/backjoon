import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                pq.add(Integer.parseInt(s[j]));
            }

        }

        for (int i = 0; i < N; i++) {
            if(i == N-1) System.out.println(pq.peek());
            else  pq.poll();
        }

    }
}

//5
//12 7 9 15 5
//13 8 11 19 6
//21 10 26 31 16
//48 14 28 35 25
//52 20 32 41 49