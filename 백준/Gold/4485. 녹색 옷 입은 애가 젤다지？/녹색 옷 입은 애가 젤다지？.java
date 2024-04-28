
import java.awt.*;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int dx[] ={-1,1,0,0} , dy[] = {0,0,-1, 1};
    static int map[][];
    static int N;
    static int dist[][];
    static final int max = 987654321;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int state = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s[] = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }
            djk();
            sb.append("Problem ").append(state++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);

    }

    private static void djk() {
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], max);
        }

        dist[0][0] = map[0][0];
        ArrayDeque<Move> dq = new ArrayDeque<>();
        dq.add(new Move(new Point(0, 0), 0));

        while (!dq.isEmpty()) {
            Move poll = dq.poll();

            if(dist[poll.p.y][poll.p.x] < poll.move) continue;

            for (int i = 0; i < 4; i++) {
                int x = dx[i] + poll.p.x;
                int y = dy[i] + poll.p.y;
                if (x >= 0 && x < N && y >= 0 && y < N) {
                    if (dist[poll.p.y][poll.p.x] + map[y][x] < dist[y][x]) {
                        dist[y][x] = dist[poll.p.y][poll.p.x] + map[y][x];
                        dq.add(new Move(new Point(x, y), dist[y][x]));
                    }
                }

            }

        }

    }

    public static class Move{
        Point p;
        int move;

        public Move(Point p, int move) {
            this.p = p;
            this.move = move;
        }
    }

}
