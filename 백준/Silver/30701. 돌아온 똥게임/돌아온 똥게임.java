import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long D = Long.parseLong(st.nextToken());
        List<Integer> room1 = new ArrayList<>();
        List<Integer> room2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (a == 1) {
                room1.add(x);
            } else {
                room2.add(x);
            }
        }
        room1 = room1.stream().sorted().collect(Collectors.toList());
        room2 = room2.stream().sorted().collect(Collectors.toList());
        int count = room2.size();
        int idx = 0;
        for (Integer integer : room1) {
            if (integer < D) {
                D += integer;
                count++;
            } else {
                if (idx == room2.size()) {
                    break;
                }
                for (int j = idx; j < room2.size(); j++) {
                    D *= room2.get(j);
                    if (integer < D) {
                        count++;
                        D += integer;
                        idx = j + 1;
                        break;
                    }
                    if (j == room2.size() - 1) {
                        idx = j + 1;
                    }
                }
            }
//            System.out.println(integer + " " + count + " " + D);
        }

        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }
}

