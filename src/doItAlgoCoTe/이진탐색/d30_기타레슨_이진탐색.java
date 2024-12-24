package doItAlgoCoTe.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2343
public class d30_기타레슨_이진탐색 {
    private static int N, M;
    private static int[] lecture;
    private static int start, end;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        lecture = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            setIndex(lecture[i]);
        }

        System.out.println(binarySearch());
    }

    private static void setIndex(final int lecture) {
        if (start < lecture) {
            start = lecture;
        }
        end += lecture;
    }

    private static int binarySearch() {
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = calcCnt(mid);            

            if (cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static int calcCnt(final int mid) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (sum + lecture[i] > mid) {
                cnt++;
                sum = 0;
            }
            sum += lecture[i];
        }

        if (sum != 0) {
            cnt++;
        }
        return cnt;
    }
}
