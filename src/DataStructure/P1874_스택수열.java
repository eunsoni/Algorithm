package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int N = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int num = 1;
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        for (int a_n : A) {
            if (a_n >= num) {
                while (a_n >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int su = stack.pop();
                if (su > a_n) {
                    System.out.println("NO");
                    flag = false;
                    break;
                } else {
                    sb.append("-\n");
                }

            }
        }
        if (flag) {
            System.out.println(sb.toString());
        }
    }
}
