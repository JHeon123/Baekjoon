import java.io.*;


public class P10819 {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n;
    static String[] inputStr;
    static int[] inputInt;
    static boolean [] visited;
    static int ar[];
    static int sum_max = -1;

    public static void main(String[] args) throws NumberFormatException, IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        inputStr = br.readLine().split(" ");
        inputInt = new int[n];
        for(int i = 0; i < n; i++){
            inputInt[i] = Integer.parseInt(inputStr[i]);
        }

        visited = new boolean[n]; // ar[]의 각 인덱스에 대한 방문이 아닌, 숫자 1~n의 방문여부임
        ar = new int[n];

        dfs(0);

        bw.write(sum_max + "\n");

        bw.flush();
        br.close();
        bw.close();
    }


    // 이 함수는 직관적이지 않으므로 그림을 그려 이해하는게 좋음
    public static void dfs(int depth) throws IOException {
        if(depth == n){
//            for(int i = 0; i < n; i++){
//                bw.write(ar[i] + " ");
//            }
//            bw.write("\n");

            int sum = 0;
            for(int i = 0; i <= n - 2; i++) {
                int gap = Math.abs(ar[i] - ar[i + 1]);
                sum = sum + gap;
            }

            if (sum > sum_max){
                sum_max = sum;
            }

            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                ar[depth] = inputInt[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }


    }

}
