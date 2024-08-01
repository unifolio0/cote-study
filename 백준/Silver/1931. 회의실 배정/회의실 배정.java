import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Time> times = new ArrayList<>();
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        List<Time> collect = times.stream().sorted().collect(Collectors.toList());
        long count = 0;
        Time time = new Time(0, 0);
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).start >= time.end) {
                time = collect.get(i);
                count++;
            }
        }
        bw.write(String.valueOf(count));

        br.close();

        bw.flush();
        bw.close();
    }

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Time time = (Time) o;
            return start == time.start && end == time.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public int compareTo(Time o) {
            if (end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
    }
}
