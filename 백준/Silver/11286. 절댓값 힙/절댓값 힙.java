import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int com;

        MyCmp cmp = new MyCmp();
        PriorityQueue<Integer> pq = new PriorityQueue<>(cmp);

        for (int t = 0; t < T; t++) {
            com = Integer.parseInt(br.readLine());
            if (com == 0) {
                Integer k = pq.poll();
                if (k != null) {
                    bw.write(String.valueOf(k) + "\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                pq.add(com);
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}

class MyCmp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        int n1 = Math.abs(o1);
        int n2 = Math.abs(o2);
        if (n1 == n2) {
            return o1 - o2;
        }

        return n1 - n2;
    }

}