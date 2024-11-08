import java.util.*;

class Solution {
    int dx[] = {0,1,1,1,0,-1,-1,-1};
    int dy[] = {-1,-1,0,1,1,1,0,-1};
    int answer;
    final int POINT_X = 0;
    final int POINT_Y = 0;
    
    Set<Point> points;  
    Set<String> edges;  

    
    public class Point implements Comparable<Point>{
        int x, y;
        
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return "x: " + this.x + "  y: " +this.y;
        }
        
        @Override
        public int compareTo(Point o1){
            if(this.x == o1.x)
                return Integer.compare(this.x,o1.x);
            return Integer.compare(this.y,o1.y);
        }
        
        @Override
        public boolean equals(Object o ){
            if(this == o) return true;
            if(!(o instanceof Point)) return false;
            Point p = (Point) o;
            return p.x == this.x && p.y == this.y;
        }
        
        @Override 
        public int hashCode(){            
            return Objects.hash(x,y);
        }
        
    }
    public int solution(int[] arrows) {
        
        init(arrows);
        findAnswer(arrows);
        return answer;
    }
    
    public void findAnswer(int [] arrows){
        Point cur = new Point(POINT_X,POINT_Y);
        
        points.add(cur);
        for(int arrow : arrows){
            
            for(int i=0; i<2; i++){
                int nextX = cur.x + dx[arrow];
                int nextY = cur.y + dy[arrow];
                
                Point next = new Point(nextX,nextY);
                
                if(points.contains(next)){
                    
                    if(!edges.contains(makeEdges(cur,next))){
                        answer++;
                    }
                }
                
                
                points.add(next);
                edges.add(makeEdges(cur,next));
                edges.add(makeEdges(next,cur));
                
                cur = next;
                
            }
            
        }
        
        
        
    }
    
    public void init(int [] arrows){
        answer=0;
        points = new HashSet<>();
        edges = new HashSet<>();
        
    }
    public String makeEdges(Point p1, Point p2){
      return p1.x + "," + p1.y + "->" + p2.x + "," + p2.y;
    }
}