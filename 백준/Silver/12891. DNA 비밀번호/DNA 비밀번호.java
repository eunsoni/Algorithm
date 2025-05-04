import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int checkArr[] = new int[4];
    static int stateArr[] = new int[4];
    static int count = 0;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t_length = Integer.parseInt(st.nextToken());
        int w_length = Integer.parseInt(st.nextToken());
        char A[] = new char[t_length];
        A = br.readLine().toCharArray();
        st= new StringTokenizer(br.readLine());
        // 조건 배열 정의
        for(int i =0 ; i<4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i]==0){
                count+=1;
            }
        }
        // 상태 배열 처음 상태 정의
        for(int i = 0 ; i < w_length; i++ ){
            Add(A[i]);
        }
        if(count == 4){
            result+=1;
        }
        // 윈도우 이동
        for(int i = 1; i<t_length-w_length+1; i++){
            int j = i+w_length-1;
            Add(A[j]);
            Sub(A[i-1]);
            if(count == 4){
                result+=1;
            }
        }
        System.out.println(result);
    }

    private static void Sub(char c) {
        switch(c){
            case 'A':
                if(checkArr[0] == stateArr[0]) count--;
                stateArr[0]--;
                break;
            case 'C':
                if(checkArr[1] == stateArr[1]) count--;
                stateArr[1]--;
                break;
            case 'G':
                if(checkArr[2] == stateArr[2]) count--;
                stateArr[2]--;
                break;
            case 'T':
                if(checkArr[3] == stateArr[3]) count--;
                stateArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch(c){
            case 'A':
                stateArr[0]++;
                if(checkArr[0] == stateArr[0]) count++;
                break;
            case 'C':
                stateArr[1]++;
                if(checkArr[1] == stateArr[1]) count++;
                break;
            case 'G':
                stateArr[2]++;
                if(checkArr[2] == stateArr[2]) count++;
                break;
            case 'T':
                stateArr[3]++;
                if(checkArr[3] == stateArr[3]) count++;
                break;
        }
    }
}
