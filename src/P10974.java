import java.io.*;


public class P10974 {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n;
    static boolean [] visited;
    static int ar[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1]; // ar[]의 각 인덱스에 대한 방문이 아닌, 숫자 1~n의 방문여부임.
        ar = new int[n];

        dfs(0);


        bw.flush();
        br.close();
        bw.close();
    }


    // 이 함수는 직관적이지 않으므로 그림을 그려 이해하는게 좋음
    public static void dfs(int depth) throws IOException {
        if(depth == n){
            for(int i = 0; i < n; i++){
                bw.write(ar[i] + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                ar[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }


    }

}
