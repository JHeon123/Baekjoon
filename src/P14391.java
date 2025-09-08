import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P14391 {
    
    public static int N, M;
    public static int[][] ar;
    public static int max = -1; 
    public static boolean [][] visited;
    
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String [] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        
        ar = new int[N][M];
        visited = new boolean[N][M];
        
        
        String [] temp;
        for(int i = 0; i < N; i++){
            temp = br.readLine().split("");
            for(int j = 0; j < M; j++){
                ar[i][j] = Integer.parseInt(temp[j]);
            }
        }
        
        dfs(0, 0);
        
        bw.write(max + "\n");
        
        bw.flush();
        bw.close();
        br.close();
        
        
        
    }
    
    public static void dfs(int x, int y){
        if(x == N){
            max = Math.max(max, calcu());
            return;
        }
        
        int nextX = x;
        int nextY = y + 1;
        if(nextY == M){
            nextX++;
            nextY = 0;
        }
        
        // 가로로 자르기
        visited[x][y] = true;
        dfs(nextX, nextY);
        
        // 세로로 자르기
        visited[x][y] = false;
        dfs(nextX, nextY);            
    }
    
    public static int calcu(){
        int sum = 0;
        
        // 가로 합
        for(int i = 0; i < N; i++){
            int cur = 0;
            for(int j = 0; j < M; j++){
                if(visited[i][j]){
                    cur = cur * 10 + ar[i][j];
                }
                else{
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        
        
        // 세로 합
        for(int i = 0; i < M; i++){
            int cur = 0;
            for(int j = 0; j < N; j++){
                if(!visited[j][i]){
                    cur = cur * 10 + ar[j][i];
                }
                else{
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        
        return sum;
    }
    
    
}
