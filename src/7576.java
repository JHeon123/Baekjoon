import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int M, N; // 가로, 세로
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우 x
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우 y

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String [] MN = br.readLine().split(" ");

        M = Integer.parseInt(MN[0]); // 가로
        N = Integer.parseInt(MN[1]); // 세로

        // 박스 생성, 방문체크 생성
        box = new int[N][];
        visited = new boolean[N][];
        for(int i = 0; i < N; i++){
            box[i] = new int[M];
            visited[i] = new boolean[M];
        }

        
        // 박스 입력
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(input[j]); 
            }
        }
        

        // bfs
        bfs();


        int max = Integer.MIN_VALUE;
        // 익지 않은 토마토가 있으면 결과는 -1
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, box[i][j]);
            }
        }


        // 출력
        System.out.println(max - 1);
        


        // 스트림닫기
        bw.flush();
        br.close();
        bw.close();

    }


    static void bfs(){

        // 큐 생성
        Queue<int[]> queue = new LinkedList<>();        

        // 익은 토마토들 싹다 큐에 집어 넣기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 1){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int current[] = queue.poll();

            int currentY = current[0];
            int currentX = current[1];

            for(int i = 0; i < 4; i++){
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];

                // 방문 범위 체크
                if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= M){
                    continue;
                }
                
                // 방문했거나, 토마토가 없거나, 익은거면 continue
                if(visited[nextY][nextX] == true || box[nextY][nextX] != 0){
                    continue;
                }

                queue.add(new int[]{nextY, nextX});
                box[nextY][nextX] = box[currentY][currentX] + 1;
                visited[nextY][nextX] = true;
            
            }
        }    
        
    }
    
}
