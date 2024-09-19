import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int S = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        if (S % 4763 != 0) {
            bw.write("0");
        } else {
            int k = S / 4763;
            for (int i = 0; i <= 200; i++) {
                for (int j = 0; j <= 200; j++) {
                    if ((i * 508) + (j * 212) == k || (i * 508) + (j * 305) == k || (i * 108) + (j * 212) == k || (i * 108) + (j * 305) == k) {
                        list.add(new int[]{i, j});
                    }
                }
            }
            List<int[]> list1 = list.stream().sorted((i1, i2) -> {
                if (i1[0] == i2[0]) {
                    return i1[1] - i2[1];
                } else {
                    return i1[0] - i2[0];
                }
            }).collect(Collectors.toList());
            if (list1.isEmpty()) {
                bw.write("0");
            } else {
                bw.write(list1.size() + "\n");
                for (int i = 0; i < list1.size(); i++) {
                    bw.write(list1.get(i)[0] + " " + list1.get(i)[1] + "\n");
                }
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
