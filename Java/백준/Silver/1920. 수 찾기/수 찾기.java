import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i = 0 ; i <N ; i ++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        int target[] = new int[M];
        for(int k = 0 ; k < M; k++){
            target[k] = sc.nextInt();
        }
        for (int i = 0 ; i < M; i++){
            int s = 0;
            int e = N-1;
            int m = (s+e)/2;
            boolean flag = false;
            while(s<=e){
                m = (s+e)/2;
                if (target[i] < A[m]){
                    e = m-1;
                }else if(target[i]>A[m]){
                    s = m+1;
                }else{
                    flag = true;
                    System.out.println(1);
                    break;
                }
            }
            if(!flag){
                System.out.println(0);
            }
        }

    }
}
