import java.io.*;
import java.util.Arrays;


public class P15663 {
    static int n;
    static int m;
    static boolean visited[];
    static int result[];
    static BufferedReader br;
    static BufferedWriter bw;
    static int input[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // n, m입력
        String [] nm  = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        // 수열입력
        String [] ar = br.readLine().split(" ");
        input = new int[n];
        for (int i = 0; i < n; i++){
            input[i] = Integer.parseInt(ar[i]);
        }

        // 수열 오름차순정렬
        Arrays.sort(input);

        visited = new boolean[n]; // 방문체크
        result = new int[m]; // 출력할 결과

        dfs(0);

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int depth) throws IOException{
        if(depth == m){ // 깊이가 m에 도달했으면 결과 출력
            for(int i = 0; i < m; i++){
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int prev = -1; // 이전에 선택한 숫자 저장

        for (int j = 0; j < n; j++) {
            if (!visited[j] && prev != input[j]) { // 방문하지 않았고, 중복이 아닐 때만 선택
                visited[j] = true;
                result[depth] = input[j];
                prev = input[j]; // 이전 값 업데이트

                dfs(depth + 1); // 깊이 1 추가해서 재귀호출

                visited[j] = false; // 원상복구
            }
        }

    }

}
