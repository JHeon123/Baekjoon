import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class P2529 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

    static boolean visited[] = new boolean[10];
    static int k;
    static char [] sign;
    static List<String> validNumbers = new ArrayList<>();


    public static void main(String[] args) throws NumberFormatException, IOException {

        k = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split(" ");

        sign = new char[k];
        for(int i = 0; i < k; i++){
            sign[i] = input[i].charAt(0);
        }


        dfs(0, "");

        // List를 정렬할땐 Collections.sort(). 배열을 정렬할땐 Arrays.sort().
        Collections.sort(validNumbers);
        bw.write(validNumbers.get(validNumbers.size() - 1) + "\n");
        bw.write(validNumbers.get(0) + "\n");


        bw.flush();
        br.close();
        bw.close();
    }


    static void dfs(int depth, String number){

        if(depth == k+1){
            boolean check = true;
            for(int i = 0; i < k; i++){
                int a = number.charAt(i) - '0';
                int b = number.charAt(i+1) - '0';

                if((sign[i] == '<' && a < b) || (sign[i] == '>' && a > b )){
                    continue;
                }
                else check = false;
            }

            if(check){
                validNumbers.add(number);
            }
        }


        for(int i = 0; i <= 9; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, number + i);
                visited[i] = false;
            }
        }
    }



}
