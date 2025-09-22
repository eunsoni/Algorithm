import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] D = new long[1001];
        D[1] = 1;
        D[2] = 2;
        for (int i = 3; i <= n; i++) {
            D[i] = (D[i - 1] + D[i-2]) % 10007;
        }
        System.out.println(D[n]);
    }
}
