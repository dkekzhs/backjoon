import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if (arr[start] + arr[end] == arr[i]) {
                    if (start == i) {
                        start++;
                        continue;
                    }
                    if (end == i) {
                        end--;
                        continue;
                    }
                    answer++;
                    break;
                }
                if (arr[start] + arr[end] > arr[i]) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        System.out.println(answer);
    }
}
