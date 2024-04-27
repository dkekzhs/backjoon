import java.io.*;
import java.util.HashSet;

public class Main {
    static int N, K;
    static HashSet<Integer> visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        visited = new HashSet<>();

        char[] ham = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if(ham[i] == 'P'){
                for (int j = Math.max(0,i-K); j <= i+K && j<N; j++) {
                    if(j == i ) continue;

                    if(ham[j] =='H' && !visited.contains(j)){
                        visited.add(j);
                        break;
                    }

                }

            }
        }

        System.out.println(visited.size());

    }
}

