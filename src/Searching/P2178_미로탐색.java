package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N, M;
    static boolean[][] visited;
    static int[][] A;
    static int depth = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        A = new int[N][M];
        for(int x = 0 ; x < N; x++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int y = 0; y < M; y++){
                    A[x][y] = Integer.parseInt(line.substring(y,y+1));
            }

        }
        BFS(0,0);
        System.out.print(A[N-1][M-1]);
    }
    public static void BFS(int i, int j){
       Queue<int[]> queue = new LinkedList<>();
       queue.offer(new int[] {i,j});
       visited[i][j] = true;
       while(!queue.isEmpty()){
           int now[] = queue.poll();
           for(int k = 0 ; k< 4; k++) {
               int x = now[0] + dx[k];
               int y = now[1] + dy[k];
               if(x>=0 && y>=0 && x < N && y < M ){
                   if(A[x][y] == 1 && !visited[x][y]){
                       queue.add(new int[] {x,y});
                       visited[x][y] = true;
                       A[x][y] = A[now[0]][now[1]]+1;
                       }
               }
           }
       }
    }
}

