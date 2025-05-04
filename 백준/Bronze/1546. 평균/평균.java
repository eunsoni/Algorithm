import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int sum = 0;
        int max = 0;
        for(int j= 0 ; j<N; j++){
            A[j] = sc.nextInt();
            if(A[j]>max){
                max=A[j];
            }
            sum+=A[j];
        }
        System.out.print(sum*100.0/max/N);
    }
}
