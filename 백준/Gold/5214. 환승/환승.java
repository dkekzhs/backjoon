import java.util.*;
import java.io.*;


public class Main {
    static boolean visited[],tubeVisited[];
    static int N,K, M;
    static ArrayList<Integer>[] tubes,stations;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s [] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        M = Integer.parseInt(s[2]);

        tubes = new ArrayList[M + 1];
        stations = new ArrayList[N + 1];

        for (int i = 0; i <=N ; i++) {
            stations[i] = new ArrayList<>();
        }

        for (int i = 0; i <= M; i++) {
            tubes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            s = br.readLine().split(" ");

            for (String string : s) {
                int station = Integer.parseInt(string);
                stations[station].add(i);
                tubes[i].add(station);

            }
        }

        visited = new boolean[N + 1];
        tubeVisited = new boolean[M + 1];

        int answer = 0;
        Deque<int []> pq = new ArrayDeque<>();
        pq.add(new int[]{1, 1});
        visited[1] = true;

        while (!pq.isEmpty()) {
            int [] data = pq.poll();
            int now = data[0];
            int depth = data[1];

            if (now == N) {
                answer = depth;
                break;
            }

            for(int tube : stations[now]) {
                if(tubeVisited[tube]) continue;
                tubeVisited[tube] = true;

                for (int next : tubes[tube]) {
                    if(visited[next]) continue;
                    visited[next] = true;
                    pq.add(new int[]{next, depth + 1});
                }
            }

        }

        System.out.println(answer == 0 ? -1 : answer);

    }





}

