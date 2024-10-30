import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;
    static int map[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        map = new int[N];

        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(map);

        int k = Integer.parseInt(br.readLine());
        int start = 0, end = N - 1;
        int answer = 0;

        while (start < end) {
            int hap = map[start] + map[end];

            if(hap >= k){
                if(k == hap) answer++;
                end--;

            }
            if(hap < k) {
                start++;

            }
        }
        System.out.println(answer);


    }


}

