import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int A[] = new int[N+1];
        for(int i = 2; i < N+1; i++){
            A[i] = i;
        }
        for(int j = 2; j<= Math.sqrt(N); j++){
            if(A[j] == 0 ) continue;
            for(int i = j+j ; i <= N; i=i+j){
                A[i] = 0;
            }
        }
        for(int i = M; i<=N; i++){
            if(A[i] == 0) continue;
            System.out.println(i);
        }
    }
}
