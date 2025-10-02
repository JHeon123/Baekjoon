import java.io.*;
import java.util.*;

class Main {

    static int N; // 세로 (행)
    static int M; // 가로 (열)
    static int[][] graph;
    static boolean[][] visited;

    // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dy = {-1, 1, 0, 0}; // y축 이동
    static int[] dx = {0, 0, -1, 1}; // x축 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write(graph[N - 1][M - 1] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentY = current[0];
            int currentX = current[1];

            // 4방향 탐색 (상, 하, 좌, 우)
            for (int i = 0; i < 4; i++) {
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];

                // 1. 미로의 범위를 벗어나는지 확인
                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                // 2. 이미 방문했거나 벽인지 확인
                if (visited[nextY][nextX] || graph[nextY][nextX] == 0) {
                    continue;
                }

                // 3. 이동할 수 있는 칸이면
                queue.add(new int[]{nextY, nextX});
                visited[nextY][nextX] = true;
                // 이전 칸의 값(거리) + 1을 하여 현재 칸에 저장
                graph[nextY][nextX] = graph[currentY][currentX] + 1;
            }
        }
    }
}
