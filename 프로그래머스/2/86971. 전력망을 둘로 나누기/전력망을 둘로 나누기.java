import java.util.*;

class Solution {
    int[][] map;
    final int CONNECT = 1;
    final int MAXLEN = 102;  
    final int TEAM1 = 1;
    final int TEAM2 = 2;
    
    int answer = Integer.MAX_VALUE;  
    
    public int solution(int n, int[][] wires) {
        input(n, wires);  
        start(n, wires);  
        return answer;    
    }
    
    public void start(int n, int[][] wires) {
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            cutingAndFindAnswer(n, from, to);  
        }
    }
    
    public void cutingAndFindAnswer(int n, int from, int to) {
        
        map[from][to] = 0;
        map[to][from] = 0;
        
        bfs(n, from, to);  
        
        
        map[from][to] = CONNECT;
        map[to][from] = CONNECT;
    }
    
    public void bfs(int n, int from, int to) {
        int[] visited = new int[n + 1];  
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{from, TEAM1});  
        dq.add(new int[]{to,TEAM2});
        visited[from] = TEAM1;
        
        while (!dq.isEmpty()) {
            int[] p = dq.poll();
            int node = p[0];
            int teamID = p[1];
            
            for (int next = 1; next <= n; next++) {  
                if (map[node][next] == CONNECT && visited[next] == 0) {
                    visited[next] = teamID;
                    dq.add(new int[]{next, teamID});
                }
            }
        }
        
        
        int team1Count = 0;
        int team2Count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == TEAM1) team1Count++;
            else if (visited[i] == TEAM2) team2Count++;
        }
        
        answer = Math.min(answer, Math.abs(team1Count - team2Count));
    }
    
    public void input(int n, int[][] wires) {
        map = new int[n + 1][n + 1];  
        
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            map[from][to] = CONNECT;
            map[to][from] = CONNECT;
        }
    }
}
