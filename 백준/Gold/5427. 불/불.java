import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int FIRE = 2;

    static int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    static int testCase, N, M;
    static int[][] map;
    static int[][] fireSpread; 
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
    }

    private static void play(BufferedReader br) throws Exception {
        String s[] = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        Point start = null;
        Queue<Point> fireQueue = new LinkedList<>();
        map = new int[N][M];
        fireSpread = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                fireSpread[i][j] = Integer.MAX_VALUE; 
                switch (s[j]) {
                    case "#":
                        map[i][j] = WALL;
                        break;
                    case "*":
                        map[i][j] = FIRE;
                        fireQueue.add(new Point(j, i));
                        fireSpread[i][j] = 0;
                        break;
                    case "@":
                        start = new Point(j, i);
                        break;
                    default:
                        map[i][j] = EMPTY;
                }
            }
        }

        spreadFire(fireQueue);

        answer = bfs(start);
    }

    private static void spreadFire(Queue<Point> fireQueue) {
        while (!fireQueue.isEmpty()) {
            Point fire = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = fire.x + dx[i];
                int ny = fire.y + dy[i];

                if (isInRange(nx, ny) && map[ny][nx] == EMPTY && fireSpread[ny][nx] == Integer.MAX_VALUE) {
                    fireSpread[ny][nx] = fireSpread[fire.y][fire.x] + 1;
                    fireQueue.add(new Point(nx, ny));
                }
            }
        }
    }

    private static int bfs(Point start) {
        Queue<Play> dq = new LinkedList<>();
        visited[start.y][start.x] = true;
        dq.add(new Play(start.x, start.y, 0));

        while (!dq.isEmpty()) {
            Play player = dq.poll();

            if (isAtBorder(player.x, player.y)) {
                return player.count + 1;
            }

            for (int i = 0; i < 4; i++) {
                int x = player.x + dx[i];
                int y = player.y + dy[i];

                if (isInRange(x, y) && map[y][x] == EMPTY && !visited[y][x]) {
                    if (fireSpread[y][x] > player.count + 1) {
                        visited[y][x] = true;
                        dq.add(new Play(x, y, player.count + 1));
                    }
                }
            }
        }
        return -1; 
    }

    private static boolean isAtBorder(int x, int y) {
        return x == 0 || x == M - 1 || y == 0 || y == N - 1;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    private static void init(BufferedReader br) throws Exception {
        String s = br.readLine();
        testCase = Integer.parseInt(s);
        while (testCase-- > 0) {
            answer = -1;
            play(br);
            System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
        }
    }

    public static class Play {
        int x, y, count;

        public Play(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
