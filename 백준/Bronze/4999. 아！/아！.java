import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        String a = br.readLine();
        String b = br.readLine();
        if (a.length() < b.length()) {
            bw.write("no");
        } else {
            bw.write("go");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}