import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    static long MAX = 51_000_000_005L;
    static int N, M, K;
    static List<Point> graph[];
    static long dist[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);

        graph = new ArrayList[N + 1];
        dist = new long[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j <= K; j++) {
                dist[i][j] = MAX;
            }
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            graph[a].add(new Point(b, cost));
            graph[b].add(new Point(a, cost));
        }

        djk();

        long answer = Long.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            answer = Math.min(answer, dist[N][i]);
        }
        System.out.println(answer);
    }

    private static void djk() {
        PriorityQueue<Data> pq = new PriorityQueue<Data>();
        pq.add(new Data(1, 0, 0));
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            Data poll = pq.poll();
            int now = poll.node;
            long cost = poll.cost;
            int count = poll.count;

            if (cost > dist[now][count]) continue;

            for (Point p : graph[now]) {
                int nextNode = p.x;
                int nextCost = p.y;

                long nopoCost = nextCost + cost;

                if (nopoCost < dist[nextNode][count]) {
                    dist[nextNode][count] = nopoCost;
                    pq.add(new Data(nextNode, nopoCost, count));
                }
                if (count < K && cost < dist[nextNode][count + 1]) {
                    dist[nextNode][count + 1] = cost;
                    pq.add(new Data(nextNode, cost, count + 1));
                }
            }
        }
    }

    public static class Data implements Comparable<Data> {
        int count;
        int node;
        long cost;

        public Data(int node, long cost, int count) {
            this.count = count;
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Data o1) {
            return Long.compare(this.cost, o1.cost);
        }
    }
}
