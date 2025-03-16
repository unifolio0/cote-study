import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        int length = str.length();
        List<String> goodstr = new ArrayList<>();
        
        for (int i = 0; i < length - 1; i++) {
            if (str.charAt(i) == '(' && str.charAt(i + 1) == ')') {
                goodstr.add("()"
                );
                break;
            }
        }
        
        for (int i = 0; i < goodstr.size(); i++) {
            int cnt = 1, substrLength = goodstr.get(i).length();
            while (substrLength * cnt + 2 <= length) {
                StringBuilder newGoodStr = new StringBuilder();
                for (int j = 0; j < cnt; j++) {
                    newGoodStr.append(goodstr.get(i));
                }
                newGoodStr.insert(0, '(').append(')');
                cnt++;
                
                int newLength = newGoodStr.length(), idx = 0;
                for (int j = 0; j < length; j++) {
                    if (str.charAt(j) == newGoodStr.charAt(idx)) {
                        idx++;
                    }
                    if (idx == newLength) {
                        break;
                    }
                }
                
                if (idx == newLength) {
                    goodstr.add(newGoodStr.toString());
                } else {
                    break;
                }
            }
        }
        
        if (goodstr.isEmpty() || goodstr.size() < k) {
            bw.write("-1");
        } else {
            Collections.sort(goodstr);
            bw.write(goodstr.get(k - 1));
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
