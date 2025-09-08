import java.io.*;


public class P15661 {
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

        for(int i = 1; i <= N/2; i++){
            dfs(0, 0, i);
        }

        bw.write(minGap+"");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int start, int depth, int memberCnt) throws IOException{

        if(depth == memberCnt){
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

            minGap = Math.min(minGap, Math.abs(sumOfStart - sumOfLink));

            return;
        }


        for(int i = start; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, depth + 1, memberCnt);
                visited[i] = false;
            }
        }

    }




}
