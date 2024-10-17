import java.awt.*;
import java.awt.List;
import java.io.*;
import java.util.*;


//첫째줄 지름길 개수 N 고속도로 길이 D
// N개의 줄까지 시작위치 도착위치 지름길 길이
public class Main {
    static ArrayList<ShortWay> list;
    static int N, D;
    static int answer;
    static final int MAX = 10001;

    static class Player {
        int location, cost;

        public Player(int location, int cost) {
            this.location = location;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "location=" + location +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();
        input(br);
        play();
        print();
    }

    private static void print() {
        System.out.println(answer);
    }

    private static void play() {
        int[] dist = new int[MAX];
        Arrays.fill(dist, 987654321);
        dist[0] = 0;

        for (int i = 0; i <= D; i++) {
            if (i > 0) dist[i] = Math.min(dist[i], dist[i - 1] + 1);

            for (ShortWay p : list) {
                if (p.x == i && dist[p.x] + p.length < dist[p.y]) {
                    dist[p.y] = dist[p.x] + p.length;
                }
            }


        }

        answer = dist[D];
    }

    private static void init() {
        list = new ArrayList<ShortWay>();


    }

    private static void input(BufferedReader br) throws Exception {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        D = Integer.parseInt(s[1]);

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);


            list.add(new ShortWay(a, b,c));

        }


    }


    private static class ShortWay {
        int x, y, length;

        public ShortWay(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
}


