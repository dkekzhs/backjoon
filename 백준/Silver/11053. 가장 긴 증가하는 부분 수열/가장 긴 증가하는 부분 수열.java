import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int data[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		data = new int[N];
		String s[] = br.readLine().split(" ");
		int dp[] = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(s[i]);
			dp[i] = 1;
		}

		int answer = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (data[i] > data[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			answer = Math.max(dp[i], answer);
		}
		System.out.println(answer);
	}
}

//이전 값보다 크면 갱신 +1
