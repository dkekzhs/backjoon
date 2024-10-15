import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int counting[][][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        char[] c = br.readLine().toCharArray();

        counting = new int[a.length+1][b.length+1][c.length+1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                for (int k = 1; k <= c.length; k++) {

                    if(a[i-1] == b[j-1] && c[k-1] == a[i-1]) counting[i][j][k] = counting[i - 1][j - 1][k - 1] + 1;
                    else counting[i][j][k] = Math.max(counting[i][j][k-1],Math.max(counting[i - 1][j][k], counting[i][j - 1][k]));
                }
            }
        }


        System.out.println(counting[a.length][b.length][c.length]);
    }



}


