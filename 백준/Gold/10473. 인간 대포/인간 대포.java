import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static double startX,startY,endX, endY;
    static double cannon[][], table[][],dist[];
    static final int MAX = 10000000;

    static class Data implements Comparable<Data>{
        int node;
        double cost;

        public Data(int node, double cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Data o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");

        startX = Double.parseDouble(s[0]);
        startY = Double.parseDouble(s[1]);

        s = br.readLine().split(" ");

        endX = Double.parseDouble(s[0]);
        endY = Double.parseDouble(s[1]);

        N = Integer.parseInt(br.readLine());

        cannon = new double[N+ 2][2];
        table = new double[N + 2][N + 2];
        dist = new double[N + 2];

        cannon[0][0] = startX;
        cannon[0][1] = startY;
        cannon[N+1][0] = endX;
        cannon[N+1][1] = endY;

        for (int i = 1; i <=N ; i++) {
            s = br.readLine().split(" ");
            double cannonX = Double.parseDouble(s[0]);
            double cannonY = Double.parseDouble(s[1]);
            cannon[i][0] = cannonX;
            cannon[i][1] = cannonY;
        }

        for (int i = 0; i <=N +1 ; i++) {
            for (int j = 0; j <= N +1; j++) {
                if( i ==j ) continue;

                double distance = distance(i, j);

                table[i][j] = Math.min(distance / 5, Math.abs((50 - distance) / 5) + 2);
            }
        }
        Arrays.fill(dist, MAX);
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 1; i <=N+1 ; i++) {
            double distance = distance(0, i);
            dist[i] = distance / 5;
            pq.add(new Data(i, dist[i]));
        }

        while (!pq.isEmpty()) {
            Data p = pq.poll();
            int here = p.node;
            double cost = p.cost;

            if (cost > dist[here]) continue;

            for (int i = 0; i <= N + 1; i++) {
                if (here == i) continue;
                double nextDist = cost + table[here][i];
                if (nextDist < dist[i]) {
                    dist[i] = nextDist;
                    pq.add(new Data(i, nextDist));
                }
            }
        }
        System.out.printf("%06f",dist[N + 1]);
    }

    static double distance(int i, int j) {
        double x = Math.pow(cannon[i][0] - cannon[j][0], 2);
        double y = Math.pow(cannon[i][1] - cannon[j][1], 2);
        return Math.sqrt(x + y);
    }



}

