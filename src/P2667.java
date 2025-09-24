import java.io.*;
import java.util.*;
import java.lang.*;

// The main method must be in a class named "Main".
// 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고,
// 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] homes; // 지도
    static int[][] homeNum; // 집번호
    static int defaultHomeNum = 0;
    static int[] villegeCnt; // 마을당 집 개수. 인덱스1에 집번호1의 개수 저장, 인덱스2에 집번호2의 개수 저장 ....

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        // 지도, 집번호, 마을당 집 개수 생성
        homes = new int[N][];
        homeNum = new int[N][];
        villegeCnt = new int[(N * N) / 2 + 2];
        for (int i = 0; i < N; i++) {
            homes[i] = new int[N];
            homeNum[i] = new int[N];
        }

        // 지도에 값 채우기
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                homes[i][j] = input.charAt(j) - '0';
            }
        }


        // 집번호가 없으면서 집이 있는 경우 bfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (homeNum[i][j] == 0 && homes[i][j] == 1) {
                    defaultHomeNum++;
                    dfs(i, j);
                }
            }
        }

        bw.write(defaultHomeNum + "\n");

        // villegeCnt 오름차순 정렬
        for(int i = 1; i <= defaultHomeNum; i++){
            for(int j = 1; j <= defaultHomeNum - i; j++){
                if(villegeCnt[j] > villegeCnt[j + 1]) {
                    int temp = villegeCnt[j];
                    villegeCnt[j] = villegeCnt[j + 1];
                    villegeCnt[j + 1] = temp;
                }
            }
        }

        for (int i = 1; i <= defaultHomeNum; i++) {
            bw.write(villegeCnt[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int i, int j) {

        if (homeNum[i][j] != 0 || homes[i][j] == 0) { // 집번호가 있거나 집이 없으면 리턴
            return;
        } else if(homeNum[i][j] == 0){
            if (homes[i][j] == 1) { // 집번호가 없으면서 집이 있으면 집번호 부여 후 bfs
                // 방문 처리, 집번호 부여
                homeNum[i][j] = defaultHomeNum;
                villegeCnt[defaultHomeNum]++;

                // 왼쪽으로 직진
                if (j >= 1) {
                    dfs(i, j - 1);
                }

                // 오른쪽으로 직진
                if (j <= N - 2) {
                    dfs(i, j + 1);
                }

                // 위쪽으로 직진
                if (i >= 1) {
                    dfs(i - 1, j);
                }

                // 아래쪽으로 직진
                if (i <= N - 2) {
                    dfs(i + 1, j);
                }
            }
        }
    }
}
