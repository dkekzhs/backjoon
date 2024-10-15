import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int counting[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        counting = new int[a.length+1][b.length+1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {

                if(a[i-1] == b[j-1]) counting[i][j] = counting[i-1][j-1] +1;
                else counting[i][j] = Math.max(counting[i - 1][j], counting[i][j - 1]);
            }
        }

        System.out.println(counting[a.length][b.length]);
    }



}


