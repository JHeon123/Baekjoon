import java.io.*;


public class P14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

    static int N;
    static int [][] S;

    static boolean visited[];

    static int minGap = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];


        String input[];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(input[j]);
            }
        }


        dfs(0, 0);

        bw.write(minGap + "\n");



        bw.flush();
        br.close();
        bw.close();
    }

    
    // 조합문제라도 visited는 사용가능. for문의 i의 시작점이 중요.
    static void dfs(int start, int depth){
        if(depth == N/2){
            int sumOfStart = 0;
            int sumOfLink = 0;
            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    if(visited[i] && visited[j]){
                        sumOfStart += (S[i][j] + S[j][i]);
                    }

                    if(!visited[i] && !visited[j]){
                        sumOfLink += (S[i][j] + S[j][i]);
                    }
                }
            }

            minGap = Math.min(Math.abs(sumOfStart - sumOfLink), minGap);
        }


        for(int i = start; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }



}
