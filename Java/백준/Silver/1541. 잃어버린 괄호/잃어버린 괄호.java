import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = 0;
        int sum;
        String str_list[] = str.split("-");
        for (int i = 0; i < str_list.length; i++) {
            sum = mysum(str_list[i]);
            if(i == 0 ){
                result +=sum;
            }else{
                result-=sum;
            }
        }
        System.out.println(result);
    }
    public static int mysum(String str){
        int sum = 0;
        String[] one_list = str.split("\\+");
        for (int j = 0; j < one_list.length; j++) {
                sum += Integer.parseInt(one_list[j]);
        }
        return sum;
    }
}
