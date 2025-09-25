import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int w, h;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{

        
        while(true){
            // 섬 개수 초기화
            int cntOfIsland = 0;
            
            // 너비, 높이 입력
            String wh[] = br.readLine().split(" ");
            w = Integer.parseInt(wh[0]);
            h = Integer.parseInt(wh[1]);

            // 너비와 높이가 모두 0이면 프로그램 종료
            if(w == 0 && h == 0){
                break;
            }
            else{
                // 빈 지도 생성
                int [][] graph = new int[h][];
                for(int j = 0; j < h; j++){
                    graph[j] = new int[w];
                }

                // 방문 체크 지도 생성
                boolean [][] check = new boolean[h][];
                for(int j = 0; j < h; j++){
                    check[j] = new boolean[w];
                }
                
                // 지도 값 입력받기
                for(int i = 0; i < h; i++){
                    String[] input = br.readLine().split(" ");
                    for(int j = 0; j < w; j++){
                        graph[i][j] = Integer.parseInt(input[j]);
                    }
                }


                /* 출력 테스트
                for(int i = 0; i < h; i++){
                    for(int j = 0; j < w; j++){
                        bw.write(graph[i][j] + " ");
                    }
                    bw.write("\n");
                }
                bw.write("\n");*/

                for(int i = 0; i < h; i++){
                    for(int j = 0; j < w; j++){
                        if(graph[i][j] == 1 && check[i][j] == false){
                            dfs(graph, check, i, j);
                            cntOfIsland++;
                        }
                    }
                }
                
                bw.write(cntOfIsland +"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int[][] graph , boolean[][] check, int idx1, int idx2){
        
        // 바다거나 방문했으면 리턴
        if(graph[idx1][idx2] == 0 || check[idx1][idx2] == true){
            return;
        }
        else{ // 섬이면 방문체크 후 이동
            check[idx1][idx2] = true;
            // 위로
            if(idx1 >= 1){
                dfs(graph, check, idx1 - 1, idx2);
            }

            // 아래로
            if(idx1 <= h - 2){
                dfs(graph, check, idx1 + 1, idx2);
            }

            // 왼쪽
            if(idx2 >= 1){
                dfs(graph, check, idx1, idx2 - 1);
            }
            
            // 오른쪽
            if(idx2 <= w - 2){
                dfs(graph, check, idx1, idx2 + 1);
            }

            // 왼쪽 위
            if(idx1 >= 1 && idx2 >= 1){
                dfs(graph, check, idx1 - 1, idx2 - 1);
            }

            // 왼쪽 아래
            if(idx1 <= h - 2 && idx2 >= 1){
                dfs(graph, check, idx1 + 1, idx2 - 1);
            }

            // 오른쪽 위
            if(idx1 >= 1 && idx2 <= w - 2){
                dfs(graph, check, idx1 - 1, idx2 + 1);
            }

            // 오른쪽 아래
            if(idx1 <= h - 2 && idx2 <= w - 2){
                dfs(graph, check, idx1 + 1, idx2 + 1);
            }
        }
    }



    
}
