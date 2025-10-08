import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int T; // 테스트케이스 개수
    static int L; // 체스판 한변의 길이

    static int[] start = new int[2]; // 현재 있는 칸
    static int[] end = new int[2]; // 이동하려고 하는 칸

    static int[] dx = {1, 2, 2, 1, -1, -2 ,-2 ,-1}; // 시계방향 x좌표
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2}; // 시계방향 y좌표
    
    
    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            L = Integer.parseInt(br.readLine()); // 체스판 한변의 길
            
            String[] row2 = br.readLine().split(" "); // 현재 있는 칸
            start[0] = Integer.parseInt(row2[0]);
            start[1] = Integer.parseInt(row2[1]);
            
            String[] row3 = br.readLine().split(" "); // 이동하려고 하는 칸
            end[0] = Integer.parseInt(row3[0]);
            end[1] = Integer.parseInt(row3[1]);

            bfs();            
        }


    }


    public static void bfs(){

        // 시작과 끝이 같으면 바로 0출력 후 리턴
        if(start[0] == end[0] && start[1] == end[1]){
            System.out.println(0);
            return;
        }
        
        // 체스판 생성
        int[][] chess = new int[L][L];


        // 큐 생성 및 start 삽입
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        chess[start[0]][start[1]] = 1;


        // 큐 뺑뺑이
        while(!queue.isEmpty()){
            int[] current = queue.poll(); // 큐에서 빼기
            int currentX = current[0]; // 현재 x좌표
            int currentY = current[1]; // 현재 y좌표

            
            for(int i = 0; i < 8; i++){
                int nextX = currentX + dx[i]; // 다음 x좌표
                int nextY = currentY + dy[i]; // 다음 y좌표

                // nextX, nextY 체크
                if(nextX >= L || nextY >= L || nextX < 0 || nextY < 0){
                    continue;
                }
                
                // 방문체크
                if(chess[nextX][nextY] != 0){
                    continue;
                }

                queue.add(new int[]{nextX, nextY}); // 아무 문제 없으면 큐에 삽입
                chess[nextX][nextY] = chess[currentX][currentY] + 1; // 현재 좌표의 값에서 1추가

                // 도착지면 바로 반환
                if (nextX == end[0] && nextY == end[1]) {
                    System.out.println(chess[nextX][nextY] - 1);
                    return;
                }
            }
        }
        

        System.out.println(chess[end[0]][end[1]] - 1);

        
    }
}
