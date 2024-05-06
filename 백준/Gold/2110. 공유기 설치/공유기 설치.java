
import java.io.*;
import java.util.*;

//도현이 집여러개 N개
//집에 공유기 설치할거야
//한집에 공유하기 하나만 설치 가능하고 최대한 거리 넓게해서 N개 공유기 설치
//가장 인접한 공유기 두개 거리 출력
// 1 2 4 8 9
public class Main {
    static int N, C;
    static int houses[];
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s [] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);
        int i = binarySearch();
        System.out.println(i);


    }

    private static int binarySearch() {
        int start = 1;
        int end = houses[N - 1] - houses[0] + 1;
        int result = 0; 
        while (start <= end) {
            int mid = (start + end) / 2;
            int install = count(mid);

            if (C <= install) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    private static int count(int mid) {
        int cnt = 1;
        int house = houses[0];
        for (int i = 1; i < houses.length; i++) {
            int cur = houses[i];
            if (cur - house >= mid) {
                cnt++;
                house = cur;
            }


        }
        return cnt;
    }
}
