import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class P11724 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static int cnt;
    
    public static void main(String [] args) throws Exception{

        String [] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]); // 정점 개수
        M = Integer.parseInt(NM[1]); // 간선 개수

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        // 방문체크 초기화
        visited = new boolean[N + 1];

        // 간선 입력
        for(int i = 0; i < M; i++){
            String [] v1v2 = br.readLine().split(" ");
            int v1 = Integer.parseInt(v1v2[0]);
            int v2 = Integer.parseInt(v1v2[1]);

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 모든 정점에 대해 dfs
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        
        bw.flush();
        br.close();
        bw.close();
        
    }


    public static void dfs(int vertex) throws Exception{

        visited[vertex] = true;

        for(int next : graph[vertex]){
            if(!visited[next]){
                dfs(next);
            }
        }  
    }
 
    
}
