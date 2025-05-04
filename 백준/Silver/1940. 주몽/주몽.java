import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int source_num = Integer.parseInt(br.readLine());
        int sum = Integer.parseInt(br.readLine());
        int start_index = 1;
        int end_index = source_num;
        int count = 0;
        int[] source_list = new int[source_num+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<source_num+1; i++){
            source_list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(source_list);
        while(start_index<end_index) {
            if (source_list[start_index] + source_list[end_index] < sum) {
                start_index++;
            } else if (source_list[start_index]+source_list[end_index]>sum) {
                end_index--;
            } else{
                count++;
                end_index--;
                start_index++;
            }
        }
        System.out.println(count);
    }
}
