import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    static int T,N,A,B;
    static ArrayList<Integer> graph[];
    static int a, b;
    static boolean visited[];
    static int answer;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            graph = new ArrayList[N + 1];

            for (int i = 0; i <=N ; i++) {
                graph[i] = new ArrayList<Integer>();
            }
            visited = new boolean[N + 1];
            answer =0;
            flag = false;
            for (int i = 0; i < N-1; i++) {
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                graph[b].add(a);
            }
            String [] s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            dfs(a);
            dfs2(b);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs2(int b) {
        if(visited[b]){
            if(flag) return;
            answer = b;
            flag = true;
            return;
        }
        visited[b]  = true;
        for (int idx :graph[b]) {
            dfs2(idx);
        }
    }

    private static void dfs(int root) {
        visited[root]  = true;
        for (int idx :graph[root]) {
            if(visited[idx]) continue;
            dfs(idx);
        }
    }



}