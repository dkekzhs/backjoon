import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        int answer = 0;
        
        for (int i = 0; i < costs.length; i++) {
            if (!isSameParent(costs[i][0], costs[i][1])) { // cycle이 생기지 않으면 union
                answer += costs[i][2];
                union(costs[i][0], costs[i][1]);
            }
        }

        return answer;
    }

    private boolean isSameParent(int node1, int node2) { // 두 노드가 같은 부모(집합)에 속하는지 확인
        node1 = find(node1);
        node2 = find(node2);
        
        if (node1 == node2)
            return true;

        return false;
    }

    private void union(int node1, int node2) { // 두 노드가 속한 집합을 합치기
      	node1 = find(node1);
      	node2 = find(node2);

      	if (node1 != node2)
          	parent[node2] = node1;
  	}

  	private int find(int node) { // 부모(대표자) 찾기
    	if(parent[node] == node)
        	return node;

    	return parent[node] = find(parent[node]);
  	}
}