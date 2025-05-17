import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int s, e, w;
    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;  // 가중치 기준으로 오름차순 정렬
    }
}

public class Main {
    static int[] parent, rank;
    static int N, K;

    // 경로 압축
    static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    // 유니온 연산
    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            if (rank[A] > rank[B]) {
                parent[B] = A;
            } else if (rank[A] < rank[B]) {
                parent[A] = B;
            } else {
                parent[B] = A;
                rank[A]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        rank = new int[N + 1];  // 랭크 배열

        // 각 정점의 부모를 자기 자신으로 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;  // 랭크 초기화
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, w));
        }

        // 간선들을 가중치 기준으로 정렬
        Collections.sort(edges);

        int ecount = 0;
        int result = 0;

        // 크루스칼 알고리즘
        for (Edge edge : edges) {
            int S = find(edge.s);
            int E = find(edge.e);
            if (S != E) {
                union(S, E);
                ecount++;
                result += edge.w;
            }
            if (ecount == N - 1) break;  // N-1개의 간선만 선택
        }

        System.out.println(result);
    }
}
