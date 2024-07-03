import java.util.*;
import java.io.*;

//같은 원소가 k개 이하로 들어가 있는 최장 부분 수열을 구하는 문제
//1. 오른쪽으로 가면서 값을 센다
//2. K보다 크면 왼쪽값을 뺀다
//3. 업데이트 한다. 끝
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int data[] = new int[N];
        int count[] = new int[100001];

        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(s[i]);
        }
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < N; right++) {
            count[data[right]]++;

            while(count[data[right]] > K){
                count[data[left]]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    }
}

