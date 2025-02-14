import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        List<Integer> times = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] parts = scanner.nextLine().split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            int totalMinutes = hour * 60 + minute; // HH:MM을 "총 분"으로 변환
            times.add(totalMinutes);
        }
        scanner.close();

        // 학생들의 원하는 시간을 오름차순 정렬
        Collections.sort(times);

        int taxis = 0; // 필요한 택시 수
        int i = 0;     // 배열 탐색 인덱스

        while (i < N) {
            taxis++; // 새로운 택시 할당
            int firstStudentTime = times.get(i);            // 현재 그룹의 기준 시간
            int maxAllowedTime = firstStudentTime + 20;         // 그룹에 속할 학생들의 원하는 시간은 firstStudentTime부터 +20분 이내여야 함
            int count = 0;
            // 최대 3명까지, 그리고 해당 학생의 원하는 시간이 maxAllowedTime 이내인 경우 그룹에 포함
            while (i < N && times.get(i) <= maxAllowedTime && count < 3) {
                i++;
                count++;
            }
        }

        System.out.println(taxis);
    }
}
