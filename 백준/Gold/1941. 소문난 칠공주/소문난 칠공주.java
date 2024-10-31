import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int LEN = 5;
    static String[][] map;
    static Set<String> answerHash;
    static int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new String[LEN][LEN];
        answerHash = new HashSet<>();

        for (int i = 0; i < LEN; i++) {
            String s[] = br.readLine().split("");
            for (int j = 0; j < LEN; j++) {
                map[i][j] = s[j];
            }
        }

        // 모든 점을 선택하여 조합을 찾기
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                points.add(new Point(i, j));
            }
        }

        // 7개 조합을 찾기
        findCombinations(points, new HashSet<>(), 0, 7);
        System.out.println(answerHash.size());
    }

    // 조합을 찾는 메서드
    private static void findCombinations(List<Point> points, Set<Point> visited, int start, int count) {
        if (visited.size() == count) {
            // S와 Y의 개수 세기
            int sCount = 0, yCount = 0;
            for (Point p : visited) {
                if (map[p.x][p.y].equals("S")) {
                    sCount++;
                } else if (map[p.x][p.y].equals("Y")) {
                    yCount++;
                }
            }

            // S의 개수가 4 이상일 경우 인접성 확인
            if (sCount >= 4) {
                if (isConnected(visited)) {
                    // 중복 방지를 위해 정렬된 문자열로 저장
                    List<Point> sortedPoints = new ArrayList<>(visited);
                    Collections.sort(sortedPoints);
                    StringBuilder sb = new StringBuilder();
                    for (Point p : sortedPoints) {
                        sb.append(p.x).append(p.y).append(" ");
                    }
                    answerHash.add(sb.toString().trim());
                }
            }
            return;
        }

        for (int i = start; i < points.size(); i++) {
            visited.add(points.get(i));
            findCombinations(points, visited, i + 1, count);
            visited.remove(points.get(i));
        }
    }

    // DFS를 사용하여 인접성 확인
    private static boolean isConnected(Set<Point> visited) {
        if (visited.isEmpty()) return false;

        // 시작점 선택
        Point start = visited.iterator().next();
        boolean[][] visitedDFS = new boolean[LEN][LEN];
        Stack<Point> stack = new Stack<>();
        stack.push(start);
        visitedDFS[start.x][start.y] = true;

        int connectedCount = 1; // 시작점 포함

        while (!stack.isEmpty()) {
            Point current = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < LEN && ny >= 0 && ny < LEN && !visitedDFS[nx][ny] && visited.contains(new Point(nx, ny))) {
                    visitedDFS[nx][ny] = true;
                    stack.push(new Point(nx, ny));
                    connectedCount++;
                }
            }
        }

        // 선택된 점의 개수와 연결된 점의 개수가 같아야 인접함
        return connectedCount == visited.size();
    }

    public static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o2) {
            if (this.x == o2.x) return this.y - o2.y;
            return this.x - o2.x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return p.x == this.x && p.y == this.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
