import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int testCase;
    static int n;
    static Integer [] data;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0){
            n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().split(" ");

            data = new Integer[n];
            for(int i=0; i< n ; i++){
                data[i] = Integer.parseInt(s[i]);
            }

            int max = data[n-1];

            long sum = 0;

            for (int i = n-1; i>=0 ; i--) {
                if(data[i] > max){
                    max = data[i];
                }
                else{
                    sum += max - data[i];
                }
            }


            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }


    }


