package Sorting;

import java.util.Scanner;

public class P1427_소트인사이드 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s_A = sc.next();
        int A[] = new int[s_A.length()];
        for (int i = 0 ; i < s_A.length() ; i ++){
            A[i] = Integer.parseInt(s_A.substring(i, i+1));
        }
        for (int i = 0 ; i< A.length ; i ++){
            int max = i;
            for(int j = i+1 ; j <A.length; j ++){
                if (A[max]<A[j]){
                    max = j;
                }
            }
            int temp = A[max];
            A[max] = A[i];
            A[i] = temp;
        }
        for (int s : A){
            System.out.print(s);
        }
    }
}
