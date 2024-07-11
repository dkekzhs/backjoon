import org.w3c.dom.Node;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    static int N, M;
    static List<Node> graph[],graph2[];
    static final int MAX = 200000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s[] = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);

            if(N ==0 && M == 0) break;
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            graph = new ArrayList[N];
            graph2 = new ArrayList[N];

            for (int i = 0; i <N ; i++) {
                graph[i] = new ArrayList<>();
                graph2[i] = new ArrayList<Node>();
            }

            for (int i = 0; i < M; i++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int cost = Integer.parseInt(s[2]);

                graph[a].add(new Node(b, cost));
                graph2[b].add(new Node(a, cost));
            }
            int[] distMin = minCost(start);
            remove(start, end, distMin, new boolean[N]);
            int[] almostMin = minCost(start);
            System.out.println(almostMin[end] == MAX ? -1 : almostMin[end]);
        }
    }

    private static void remove(int start, int now, int[] dist,boolean [] visited) {
        if(now == start || visited[now]) return;
        visited[now] = true;

        for (Node node : graph2[now]) {
            if (dist[node.node] + node.cost == dist[now]) {
                graph[node.node].removeIf(n -> n.node == now && n.cost == node.cost);
                remove(start, node.node, dist, visited);
            }
        }

    }

    private static int[] minCost(int start) {
        int dist[] = new int[N + 1];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int now = poll.node;
            int cost = poll.cost;


            if(cost > dist[now]) continue;

            for (Node node : graph[now]) {
                int next = node.node;
                int nextCost = node.cost + cost;

                if (nextCost < dist[next]) {
                    dist[next] = nextCost;
                    pq.add(new Node(next, nextCost));
                }
            }
        }
        return dist;
    }


    static class Node implements Comparable<Node>{
        int node,cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o1){
            return Integer.compare(this.cost, o1.cost);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node1 = (Node) o;
            return node == node1.node && cost == node1.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, cost);
        }
    }
}
