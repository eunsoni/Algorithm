package DP;

import java.util.Scanner;

public class P11726_2xn타일링 {
    static int[] D;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        D = new int[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            D[i] =-1;
        }
        D[1] =1;
        D[2] =2;
        int result = DP(n);
        System.out.println(result%10007);
    }

    public static int DP(int n){
        if(D[n] != -1){
            return D[n];
        }
        return D[n] = DP(n-1) + DP(n-2);
    }
}
