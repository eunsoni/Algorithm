package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {
    static boolean visited[];
    static ArrayList<Integer> A[];
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        A = new ArrayList[P+1];
        visited = new boolean[P+1];


        for(int i = 1 ; i<P+1 ; i++){
            A[i] = new ArrayList<>();
            visited[i] = false;
        }

        for(int i = 0 ; i< L; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        for(int i = 1 ; i< P+1; i++){
            if(!visited[i]){
                visited[i] =true;
                count++;
                DFS(i);
            }
        }


        System.out.print(count);
    }
    private static void DFS(int i) {
        for(int e : A[i]){
            if(!visited[e]){
                visited[e] = true;
                DFS(e);
            };
        }
    }
}
