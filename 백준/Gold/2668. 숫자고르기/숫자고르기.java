import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static ArrayList<Integer> graph [] ;
    static boolean visited [];
    static HashSet answerList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        answerList = new HashSet();
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            graph[i].add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited,false);
            dfs(i, i);
        }

        sb.append(answerList.size()).append("\n");

        List<Integer> list = new ArrayList<>(answerList);
        list.sort((o1, o2) -> Integer.compare(o1, o2));
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);



    }

    static void dfs(int idx, int start) {
        if(!visited[idx]){
            visited[idx] = true;
            for (int next :graph[idx]) {
                if(next == start) answerList.add(start);
                dfs(next, start);
            }
        }
    }
}
