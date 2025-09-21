import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int K;
    static int V, E;
    static int u, v;
    static ArrayList<Integer> adj[];
    static int colors[];
    
    public static void main(String[] args) throws IOException{

        K = Integer.parseInt(br.readLine());
        for(int j = 0; j < K; j++){
            // 정점, 간선 개수 입력
            String[] VE = br.readLine().split(" ");
            V = Integer.parseInt(VE[0]);
            E = Integer.parseInt(VE[1]);

            // 그래프 생성
            adj = new ArrayList[V + 1];
            colors = new int[V + 1];
            for(int i = 1; i <= V; i++){
                adj[i] = new ArrayList<>();    
            }

            // 그래프 간선 넣기
            for(int i = 0; i < E; i++){
                String[] uv = br.readLine().split(" ");
                u = Integer.parseInt(uv[0]);
                v = Integer.parseInt(uv[1]);

                adj[u].add(v);
                adj[v].add(u);
            }

            boolean isBipartite = true;
            // 모든 정점에 대해 bfs
            for(int i = 1; i <= V; i++){
                if(colors[i] == 0){
                    boolean result = bfs(i);
                    if(result == false){
                        isBipartite = false;
                        break;
                    }
                }
            }
            
           if (isBipartite) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean bfs(int vertex){
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 파라미터로 받는 정점 큐에 넣고 그룹1로 분류
        queue.offer(vertex);
        colors[vertex] = 1;
        
        // 큐에서 1개씩 빼내며 방문 안한 정점이면 그룹-1로 분류, 방문한 정점이면서 같은 그룹이면 false반환
        while(!queue.isEmpty()){
            int u = queue.poll();

            for(int v : adj[u]){
                if(colors[v] == 0){
                    colors[v] = colors[u] * (-1);
                    queue.offer(v);
                }
                else if(colors[u] == colors[v]) {
                    return false;
                }
            }
        }
        return true;
        
    }
        
}
