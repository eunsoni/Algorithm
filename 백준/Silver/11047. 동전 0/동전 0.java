import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int price = sc.nextInt();
        int sum = 0;
        int coinSet[] = new int[N];
        int count = 0;
        for (int k = 0 ; k <N ; k++){
            coinSet[k] = sc.nextInt();
        }
        for(int i = N-1 ; i >= 0; i--) {
            if(price >= coinSet[i]) {
                count+=price/coinSet[i];
                price = price%coinSet[i];
            }
        }
        System.out.println(count);
    }
}
