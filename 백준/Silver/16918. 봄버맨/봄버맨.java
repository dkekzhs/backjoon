import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    static int R,C,N;
    static ArrayList<Point> beam;
    static int dx[] = {-1, 1, 0, 0,0}, dy[] = {0, 0, -1, 1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        N = Integer.parseInt(s[2]);

        String  map[][] = new String[R][C];
        StringBuilder sb = new StringBuilder();
        beam = new ArrayList<Point>();


        for (int i = 0; i < R; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = s[j];
                if(map[i][j].equals("O")) beam.add(new Point(j, i));
            }
        }
        int bombTime[][] = new int[R][C];

// 모든 칸에 대해 폭탄이 설치된 시간을 -1로 초기화 (폭탄이 없는 것으로 가정)
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bombTime[i][j] = -1;
            }
        }

        for (Point p : beam) {
            bombTime[p.y][p.x] = 0;
        }

        for (int t = 1; t <= N; t++) {
            // 모든 칸에 대해
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j].equals(".") && t % 2 == 0) {
                        map[i][j] = "O";
                        bombTime[i][j] = t;
                    }
                    else if (map[i][j].equals("O") && bombTime[i][j] <= t - 3) {
                        map[i][j] = ".";
                        bombTime[i][j] = -1;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + dx[d];
                            int nj = j + dy[d];
                            if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj].equals("O") && bombTime[ni][nj] > t - 3) {
                                map[ni][nj] = ".";
                                bombTime[ni][nj] = -1;
                            }
                        }
                    }
                }
            }
        }

        print(sb, map);


    }


    private static void print(StringBuilder sb, String[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }


}