import java.io.*;



public class P10971 {

    static int n;
    static String [] inputStr;
    static int weight[][];
    static boolean visited[];
    static int min_cost = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

        n = Integer.parseInt(br.readLine());

        weight = new int[n][n];
        for(int i = 0; i < n; i++){
            inputStr = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                weight[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0);
            visited[i] = false;
        }

        bw.write(min_cost + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    // start = 처음 출발한 도시. now = 현재 도시. cost = 현재 비용
    // 참고로 dfs 깊이우선탐색은 스택을 사용한다.
    public static void dfs(int start, int now, int cost){
        if(allVisited(visited, start)){
            if(weight[now][start] == 0){ // 만약 마지막 도시에서 처음 출발 도시로 가지 못하면 return
                return;
            }
            else{ //처음 출발한 도시로 갈 수 있으면
                cost = cost + weight[now][start];
            }

            if(min_cost > cost){
                min_cost = cost;
            }

            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i] == false && weight[now][i] != 0){ // i는 다음 방문 도시
                visited[i] = true;
                dfs(start, i, cost + weight[now][i]);
                visited[i] = false;
            }
        }

    }

    public static boolean allVisited(boolean visited[], int start){
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
    }
}
