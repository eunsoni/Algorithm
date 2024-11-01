package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> Q = new PriorityQueue<>((o1, o2)->{
           int f_abs = Math.abs(o1);
           int s_abs = Math.abs(o2);
           if(f_abs == s_abs){
               return o1 - o2;
           }
           return f_abs-s_abs;
        });
        for(int i = 0 ; i < N ; i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0){
                if(Q.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(Q.poll());
                }
            }else{
                Q.add(request);
            }
        }
    }
}
