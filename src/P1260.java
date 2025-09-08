import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// The main method must be in a class named "Main".
class P1260 {

    static int N, M, V;
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception{
      
    
        String [] NMV = br.readLine().split(" ");
        N = Integer.parseInt(NMV[0]); // 정점의 개수
        M = Integer.parseInt(NMV[1]); // 간선의 개수
        V = Integer.parseInt(NMV[2]); // 탐색 시작 정점 번호

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 두 정점 번호 입력
        String [] v1v2;
        for(int i = 0; i < M; i++){
            v1v2 = br.readLine().split(" ");
            int v1 = Integer.parseInt(v1v2[0]);
            int v2 = Integer.parseInt(v1v2[1]);

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 정점 번호 작은 순서대로 방문해야하니 정렬
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        bw.write("\n");

        visited = new boolean[N + 1];
        bfs(V);

        bw.flush();
        br.close();
        bw.close();        
    }


    public static void dfs(int V) throws Exception{
        visited[V] = true;
        bw.write(V + " ");
        for(int next : graph[V]){
            if(!visited[next]){
                dfs(next);
            }
        }
        
    }

    public static void bfs(int V) throws Exception{
        Queue<Integer> queue = new LinkedList<>();
        visited[V] = true;
        queue.add(V);

        while(!queue.isEmpty()){
            int cur = queue.poll(); // 큐에서 정점 빼기
            bw.write(cur + " ");

            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
    }

    
    
}
