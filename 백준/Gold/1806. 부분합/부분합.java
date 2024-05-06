

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = check(N,S,arr);
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);

    }

    private static int check(int n,int s, int [] arr) {
        int start = 0, end = 0,sum =0, minLength = Integer.MAX_VALUE;
        while(end < n || sum >= s){
            if(s > sum){
                sum += arr[end++];
            }else{
                minLength = Math.min(minLength, end - start);
                sum -= arr[start++];
            }
        }
        return minLength;
    }
}
