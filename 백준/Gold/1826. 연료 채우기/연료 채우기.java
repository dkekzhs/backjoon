import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static class GasStation implements Comparable<GasStation>{
        int where,gas;

        public GasStation() {
        }

        public GasStation(int where, int gas) {
            this.where = where;
            this.gas = gas;
        }

        @Override
        public int compareTo(GasStation o) {
            return Integer.compare(where, o.where);
        }

        @Override
        public String toString() {
            return "GasStation{" +
                    "where=" + where +
                    ", gas=" + gas +
                    '}';
        }
    }
    static int N,end,gas;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<GasStation> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String s[] = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            pq.add(new GasStation(a, b));
        }

        String s [] = br.readLine().split(" ");
        end = Integer.parseInt(s[0]);
        gas = Integer.parseInt(s[1]);
        pq.add(new GasStation(end, 0));

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        int count =0 ;

        while (!pq.isEmpty()) {
            GasStation p = pq.poll();

            while (gas < p.where) {
                if (pq2.isEmpty()) {
                    System.out.println("-1");
                    return;
                }
                gas += pq2.poll();
                count++;
            }
            pq2.add(p.gas);
        }
        System.out.println(gas >= end ? count : -1);
    }
}