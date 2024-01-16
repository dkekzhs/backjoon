import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    static class Node{
        int b,wei;

        public Node(int b, int wei) {
            this.b = b;
            this.wei = wei;
        }
    }

    static int N,M;
    static ArrayList<Node>[] graph;
    static long dis[];
    static final long MAX = 2000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        dis = new long[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <=N ; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            graph[a].add(new Node(b, weight));
        }
        if(!bf(1)){
            for (int i = 2; i <=N ; i++) {
                if(dis[i]== MAX) System.out.println(-1);
                else System.out.println(dis[i]);
            }
        }else{
            System.out.println(-1);
        }
    }

    private static boolean bf(int idx) {
        Arrays.fill(dis,MAX);
        dis[idx] = 0;

        for (int i = 1; i <=N ; i++) {
            for (int a = 1; a <=N ; a++) {
                if(dis[a] == MAX) continue;
                for (Node p : graph[a]) {

                    if(dis[p.b] > p.wei + dis[a]){
                        dis[p.b] = p.wei + dis[a];


                        if(i == N) return true;
                    }
                }
            }
        }


        return false;
    }


}