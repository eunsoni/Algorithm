package Greedy;

import java.io.IOException;
import java.util.Scanner;

public class P1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = 0;
        String str_list[] = str.split("-");
        int sum;
        for (int i = 0; i < str_list.length; i++) {
            String one_list[] = str_list[i].split("\\+");
            sum = 0;
            for (int j = 0; j < one_list.length; j++) {
                sum += Integer.parseInt(one_list[j]);
            }
            if(i == 0 ){
                result +=sum;
            }else{
                result-=sum;
            }
        }
        System.out.println(result);
    }
}
