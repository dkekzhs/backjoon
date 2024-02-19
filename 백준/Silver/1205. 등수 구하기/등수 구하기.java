import java.io.*;
import java.util.*;


public class Main {
    static int N,point,size;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s= br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        point = Integer.parseInt(s[1]);
        size = Integer.parseInt(s[2]);

        PriorityQueue<Integer> data = new PriorityQueue<>(Collections.reverseOrder());

        if(N != 0 ){
            s = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                data.offer(Integer.parseInt(s[i]));
            }
        }
        ArrayList<Integer> temp = new ArrayList<>(data);
        if(data.size() == size && point <= temp.get(temp.size()-1)){
            System.out.println(-1);
            return;
        }else{
            data.offer(point);
        }


        int count = 1;
        while(!data.isEmpty()){
            Integer p = data.poll();
            if (p > point) {
                count++;
            }else break;
        }
        System.out.println(count);
    }
}