import java.io.*;


public class P1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

    static int N, S;
    static int [] ar;
    static int cnt = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        String [] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        String [] input1 = br.readLine().split(" ");

        ar = new int[N];

        for(int i = 0 ; i < N; i++){
            ar[i] = Integer.parseInt(input1[i]);
        }


        // dfs를 반복문으로 여러번 돌리는 방법도 있음
        for(int i = 1; i <= N; i++){
            dfs(0, 0, i, 0);
        }

        bw.write(cnt + "\n");

        bw.flush();
        br.close();
        bw.close();
    }


    static void dfs(int start, int nowDepth, int maxDepth, int sum) throws NumberFormatException, IOException {
        if(nowDepth == maxDepth){
            if(sum == S){
                cnt++;
            }
            return;
        }

        for(int i = start ; i < N; i++){
            dfs(i + 1, nowDepth + 1, maxDepth, sum + ar[i]);
        }


    }


}
