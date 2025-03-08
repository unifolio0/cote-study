import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int sum = a + b + c + d;
        bw.write(String.valueOf(sum / 60) + "\n");
        bw.write(String.valueOf(sum % 60));
        
        bw.flush();
        bw.close();
        br.close();
    }
}