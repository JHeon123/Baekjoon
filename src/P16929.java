import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int width, height;
    static String[][] graph;
    static boolean[][] visited;
    static boolean cycleStatus;
    
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        String[] input = br.readLine().split(" "); // 세로, 가로 입력
    
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);

        graph = new String[height][width];
        visited = new boolean[height][width];
        
        for(int i = 0; i < height; i++){
            String[] colors = br.readLine().split("");
            for(int j = 0; j < width; j++){
                graph[i][j] = colors[j];
            }
        }
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(!visited[i][j]){
                    dfs(i, j, -1, -1);
                }
            }
        }


        if(cycleStatus){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static void dfs(int y, int x, int prevY, int prevX){
        
        visited[y][x] = true;
        
        int curX = x;
        int curY = y;
        
        for(int i = 0; i < 4; i++){
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];


            if(nextX < 0 || nextX >= width || nextY < 0 || nextY >= height){
                continue;
            }

            if(nextY == prevY && nextX == prevX){
                continue;
            }
            
            if(graph[curY][curX].equals(graph[nextY][nextX])){
                if(visited[nextY][nextX] == true){
                    cycleStatus = true;
                    return;
                }
                
                dfs(nextY, nextX, curY, curX);
            }
        }
        
    }
}
