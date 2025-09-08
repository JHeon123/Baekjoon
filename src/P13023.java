import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 이 문제는 이해부터가 어려움.
// 응가같은 문제임 ㅇㅇ.
// 그냥 그래프 만들어서 길이가 4인 경로가 있는지 없는지 찾으면 됨.
class P13023 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int found = 0;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));         
            
        String [] NM = br.readLine().split(" ");
        N=Integer.parseInt(NM[0]);
        M=Integer.parseInt(NM[1]);

        visited = new boolean[N];

        // 그래프 초기화
        graph = new ArrayList[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        // 그래프 만들기        
        String [] temp;
        for(int i = 0; i < M; i++){
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            graph[a].add(b);
            graph[b].add(a);
        }


        // 모든 정점마다 dfs 돌리기
        for(int i = 0; i < N; i++){
            dfs(1, i);
            if(found == 1){
                break;
            }
        }
        

        bw.write(found + "\n");
        
        bw.flush();
        bw.close();
        br.close();
        
        
    }

    // depth는 방문한 정점의 수. cur는 현재 정점.
    public static void dfs(int depth, int cur) throws Exception{
        if(depth == 5){ // 깊이가 5이면 즉, 5개의 정점을 방문했으면
            found = 1;  // 길이가 4인 경로를 발견
            return;
        }

        visited[cur] = true;

        // 현재 정점에서 방문하지 않은 정점으로 이동
        for(int to : graph[cur]){
            if(!visited[to]){
                dfs(depth + 1, to);
            }
        }

        visited[cur] = false;
        
    }

    
}
