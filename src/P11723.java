import java.io.*;


public class P11723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

    // S[i]가 0이면 집합에 i가 없는거고, 1이면 존재
    static int [] S = new int[21];


    public static void main(String[] args) throws NumberFormatException, IOException {

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            if(command.equals("add")){
                int x = Integer.parseInt(input[1]);
                if(S[x] == 0) {
                    S[x] = 1;
                }
            }
            else if (command.equals("remove")) {
                int x = Integer.parseInt(input[1]);
                if(S[x] == 1) {
                    S[x] = 0;
                }
            }
            else if (command.equals("check")) {
                int x = Integer.parseInt(input[1]);
                if(S[x] == 1) {
                    bw.write("1\n");
                }
                else if(S[x] == 0) {
                    bw.write("0\n");
                }
            }
            else if(command.equals("toggle")) {
                int x = Integer.parseInt(input[1]);
                if(S[x] == 1) {
                    S[x] = 0;
                }
                else if(S[x] == 0) {
                    S[x] = 1;
                }
            }
            else if(command.equals("all")) {
                for(int j = 1; j <= 20; j++){
                    S[j] = 1;
                }
            }
            else if(command.equals("empty")) {
                for(int j = 1; j <= 20; j++){
                    S[j] = 0;
                }
            }

        }


        bw.flush();
        br.close();
        bw.close();
    }




}
