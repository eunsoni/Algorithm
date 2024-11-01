package DP;

import java.util.Scanner;

public class P11726_2xn타일링_bottomup {
    static int[] D;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        D = new int[n+1];
        D[1] =1;
        D[2] =2;
        int result = 0;
        if(n ==1 || n ==2){
            result = D[n];
        }else {
            for (int i = 3; i <= n; i++) {
                D[i] = D[i - 1] + D[i-2];
            }
            result = D[n];
        }
        System.out.println(result%10007);
    }

    public static int DP(int n){
        if(D[n] != -1){
            return D[n];
        }
        return D[n] = DP(n-1) + DP(n-2);
    }
}
