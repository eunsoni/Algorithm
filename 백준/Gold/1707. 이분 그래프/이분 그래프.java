import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testCase; t++){
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            isEven = true;
            check = new int[V+1];
            for(int i = 1; i <=V ; i++){
                A[i] = new ArrayList<Integer>();
            }
            //에지 데이터 저장
            for(int i = 1; i <= E ; i++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }
            //모든 노드에 DFS 실행 해야함
            for (int i = 1; i <= V ; i++){
                if(isEven){
                    DFS(i);
                }else{
                    break;
                }
            }
            if(isEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    private static void DFS(int start){
        visited[start] = true;
        for(int i : A[start]){
            if (!visited[i]){
                // 바로 직전 방문 노드와 분리
                check[i] = ( check[start] + 1) % 2;
                DFS(i);
            }else if(check[i] == check[start]) isEven = false;
        }
    }
}