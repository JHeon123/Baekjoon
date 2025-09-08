import java.io.*;


public class P14501_1 {
    static BufferedReader br;
    static BufferedWriter bw;

    static int N;
    static int T[], P[];
    static StringBuilder vowel = new StringBuilder(); // 모음
    static StringBuilder conso = new StringBuilder(); // 자음

    static String input [];

    static int maxMoney = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());

        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }


        dfs(0, 0);

        bw.write(maxMoney + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int depth, int myMoney) throws IOException{
        if(depth >= N){
            if(depth == N) {
                maxMoney = Math.max(myMoney, maxMoney);
            }
            return;
        }


        // 상담o
        if(depth + T[depth] <= N) { // 마지막날의 상담기간이 1일이면 딱 N이 됨
            dfs(depth + T[depth], myMoney + P[depth]);
        }

        // 상담x
        dfs(depth + 1, myMoney);


    }

}
