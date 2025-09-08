import java.io.*;


public class P14501 {
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

        // dp[i]: i번째 날까지 고려했을 때의 최대 수익
        int dp[] = new int[N+1];

        for (int i = 0; i < N; i++) {
            // 상담 가능한 경우
            if (i + T[i] <= N) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }

            // 상담 가능하든 불가능하든 상담 안 하고 그냥 넘어가는 경우도 반영
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        bw.write(dp[N] + "\n");



        bw.flush();
        br.close();
        bw.close();
    }


}
