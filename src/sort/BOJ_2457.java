package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2457 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        Date[] dates = new Date[num];

        // 월, 일 입력 받아서 Date로 생성 후 ArrayList에 저장
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            dates[i] = new Date(start, end);
        }

        Arrays.parallelSort(dates);

        // 꽃 개수 카운트 하기
        int cnt = 0;
        int beforeEnd = 301;
        int last = 1201;
        int index = 0;
        int nextEnd = 0;

        while (beforeEnd < last) {
            boolean exist = false;

            for (int i = index; i < num; i++) {
                // 이전 값이 있을거 아니야~ 걔의 end보다 다음 end값이 더 작으면 아웃 (처음 end 기준값을 301로 하면 되겠다)
                if (dates[i].start > beforeEnd) {
                    break;
                }

                // 위의 조건을 만족하는 여러 꽃들 중 가장 늦게 지는 꽃을 찾아라!
                if (dates[i].end > nextEnd) {
                    exist = true;
                    nextEnd = dates[i].end;
                    index++;
                }


            }

            if (exist) {
                cnt++;
                beforeEnd = nextEnd;
            } else {
                break;
            }
        }

        if (beforeEnd < last) {
            System.out.println("0");
        } else {
            System.out.println(cnt);
        }
    }

}

class Date implements Comparable<Date> {
    int start, end;

    public Date(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Date o) {
        if (this.start == o.start) {
            return o.end - this.end;
        }
        return this.start - o.start;
    }
}

