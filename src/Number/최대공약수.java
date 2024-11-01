package Number;

import java.util.Scanner;

public class 최대공약수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int big = sc.nextInt();
        int small = sc.nextInt();
        if (big<small){
            int temp = big;
            big = small;
            small = temp;
        }
        System.out.println(gcd(big, small));
    }
    public static int gcd(int big, int small){
        if(big%small == 0) return small;
        else{
            return gcd(small, big%small);
        }
    }
}


