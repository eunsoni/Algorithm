package DataStructure;

import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int eindex = 1;
        int sindex = 1;
        long sum = 1;
        int count = 1;
        while(eindex!=N){
            if(sum<N){
                ++eindex;
                sum+=eindex;
            } else if (sum>N) {
                sum-=sindex;
                ++sindex;
            }else{
                count++;
                ++eindex;
                sum+=eindex;
            }
        }
        System.out.println(count);
    }
}
