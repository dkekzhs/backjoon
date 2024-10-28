import java.util.*;
import java.io.*;
import java.awt.*;
public class Main {
	static int N,M,K,X;
	static ArrayList<Integer> answerList;
	static ArrayList<Point> graph[];
	static int dis[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		X = Integer.parseInt(s[3]);

		answerList = new ArrayList<Integer>();
		dis = new int[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Point>();
		}

		for (int i = 0; i < M; i++) {
			s =br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			graph[a].add(new Point(b, 1));
		}

		djk();
		if(answerList.isEmpty()){
			sb.append(-1).append("\n");
		}else{
			for (int answer :answerList) {
				sb.append(answer).append("\n");
			}
		}
		System.out.println(sb);
		
	}

	public static void djk() {
		Arrays.fill(dis, 987654321);
		dis[X] = 0;
		ArrayDeque<Point> dq = new ArrayDeque<>();
		dq.add(new Point(X, 0));

		while (!dq.isEmpty()) {
			Point poll = dq.poll();

			if(dis[poll.x] > poll.y) continue;

			for (Point  next : graph[poll.x]) {
				int nextCost = dis[poll.x] + next.y;
				if (nextCost < dis[next.x]) {
					dis[next.x] = nextCost;
					dq.add(new Point(next.x, nextCost));
				}
			}
		}

		for (int i = 0; i <= N; i++) {
			if(dis[i] == K) answerList.add(i);
		}
		Collections.sort(answerList);
	}

}
