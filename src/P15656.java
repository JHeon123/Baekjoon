import java.io.*;
import java.util.Arrays;


public class P15656 {
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

        dfs(0, 0);

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int start, int depth) throws IOException{
        if(depth == m){ // 깊이가 m에 도달했으면 결과 출력
            for(int i = 0; i < m; i++){
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int j = start; j < n; j++){
            result[depth] = input[j];
            dfs(j, depth + 1); // 재귀로 인한 반복문을 자기 자신부터 시작
        }

    }

}
