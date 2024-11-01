package Number;

import java.util.Scanner;

public class P1934_최소공배수 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0 ; i < N ;i++){
            int big = sc.nextInt();
            int small = sc.nextInt();
            if(big<small){
                int temp = big;
                big = small;
                small = temp;
            }
            System.out.println(big*small/ gcd(big,small));
        }
    }
    public static int gcd(int big, int small){
        if(big % small ==0) return small;
        else{
            return gcd(small, big%small);
        }
    }
}
