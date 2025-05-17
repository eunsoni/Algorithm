import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge> {
    int s, e, w;
    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
    // 가중치에 따라 정렬
    @Override
    public int compareTo(Edge o){
        return this.w - o.w;
    }
}

public class Main {
    static int[] parent;
    static int N, K;
    static PriorityQueue<Edge> pq;

    static int find(int a){
        if(parent[a] != a) {
            parent[a] = find(parent[a]);
            return parent[a];
        }
        return a;
    }

    static void union(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A != B) {
            parent[B] = A;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();

        parent = new int[N+1];
        //
        for (int i = 1; i <= N ; i++){
            parent[i] = i;
        }

        //에지리스트 정렬
        for (int i = 0 ; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(s, e, w));
        }

        // 크루스칼 알고리즘 수행
        int ecount = 0;  // 선택된 간선 수
        int result = 0; // 최소 스패닝 트리의 가중치 합

        while(ecount < N - 1) {
            Edge edge = pq.poll();
            int S = find(edge.s);
            int E = find(edge.e);
            if (S != E){
                union(S, E);
                ecount++;
                result += edge.w;
            }
        }

       System.out.println(result);

    }

}
