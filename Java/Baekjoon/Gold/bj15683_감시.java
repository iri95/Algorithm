package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 코드 : https://codingnojam.tistory.com/65

public class bj15683_감시 {
    // 결과값 저장변수, 최솟값을 저장해야하므로 99999로 초기화
    static int N, M, result = 99999;
    // 북 서 남 동으로 좌표 이동을 위해 사용할 배열
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        List<CCTV> cctvList = new ArrayList<>();

        // 사무실을 정보받아서 배열 초기화
        int cnt = 7;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                // CCTV인 경우
                if (temp != 0 && temp != 6) {
                    // CCTV별로 감시하는 영역을 표시할 숫자를 다르게 생성성
                    int chkNum = cnt;
                    cnt++;
                    cctvList.add(new CCTV(temp, i, j, chkNum));
                }
            }
        }
        // CCTV감시 범위 체크를 재귀형태로 구현
        recursion(cctvList, 0);
        System.out.println(result);
    }
    static class CCTV {
        int no;     // CCTV 번호
        int y;      // CCTV의 좌표 행
        int x;      // CCTV의 좌표 열
        // CCTV마다 고유한 감시번호
        // 예를들어 CCTV가 감시한 곳을 # 과같은 걸로 표시하면 중복으로 감시되는 위치를 파악할 수 없음
        // 그러므로 해당 CCTV가 감시한 곳은 고유번호로 체크
        int chkNum;

        public CCTV(int no, int y, int x, int chkNum) {
            this.no = no;
            this.y = y;
            this.x = x;
            this.chkNum = chkNum;
        }
    }

    /**
     * CCTV들이 감시하는 모든 경우의 수를 체크 하기 위한 재귀메서드
     *
     * @param cctvList : 사무실에 있는 CCTV리스트
     * @param index    : CCTV리스트에 사용할 인덱스
     */
    static void recursion(List<CCTV> cctvList, int index) {
        // 재귀메서드 진행 중 CCTV 리스트의 사이즈랑 인덱스가 같다면
        // 모든 CCTV의 방향이 정해진 상태이므로 사각지대 체크
        if (index >= cctvList.size()) {
            int tempResult = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        tempResult++;
                    }
                }
            }
            result = Math.min(tempResult, result);
            return;
        }

        // CCTV리스트에서 CCTV가져오기
        CCTV cctv = cctvList.get(index);

        // CCTV는 동서남북 4방향으로 회전 할 수 있으므로
        // 4방향 모두 감시가능한 곳을 체크 해야함
        // 0:북, 1:서, 2:남, 3:동
        for (int d = 0; d < 4; d++) {
            // CCTV 감시가능한 곳 체크
            cctvChk(cctv.no, cctv.y, cctv.x, d, cctv.chkNum);

            // 재귀메서드 실행
            // CCTV리스트에서 다음 CCTV를 꺼낼 수 있도록 인덱스 +1 증가
            recursion(cctvList, index + 1);

            // CCTV 감시했던 곳 해제
            // 2차원 배열 1개로 계속 사용하기 위해 감시한 곳 다시 빈칸으로 변경
            // 이때, CCTV끼리 중복으로 감시가능한 곳이 있을 것이기 때문에
            // CCTV별 고유감시번호로 확인을 해서 중복난 곳을 빈칸으로 바꾸지 않도록 구현
            cctvChk(cctv.no, cctv.y, cctv.x, d, cctv.chkNum);
        }
    }

    /**
     * CCTV 감시범위 체크 메서드
     *
     * @param no  : CCTV 번호
     * @param y   : CCTV가 있는 행
     * @param x   : CCTV가 있는 열
     * @param d   : CCTV가 감시하는 방향
     * @param chk : CCTV별 고유 감시번호
     */
    static void cctvChk(int no, int y, int x, int d, int chk) {
        switch (no) {
            case 1:
                chk(y, x, d, chk);
                break;
            case 2:
                chk(y, x, d, chk);
                chk(y, x, (d + 2) % 4, chk);
                break;
            case 3:
                chk(y, x, d, chk);
                chk(y, x, (d + 1) % 4, chk);
                break;
            case 4:
                chk(y, x, d, chk);
                chk(y, x, (d + 3) % 4, chk);
                chk(y, x, (d + 1) % 4, chk);
                break;
            case 5:
                for (int i = 0; i < 4; i++) chk(y, x, i, chk);
                break;
        }
    }

    /**
     * 감시카메라가 감시가능한 위치 감시번호로 체크하는 메서드
     * @param y      : CCTV의 행
     * @param x      : CCTV의 열
     * @param D      : CCTV가 감시하는 방향
     * @param chkNum : CCTV별 고유 감시번호
     */
    static void chk(int y, int x, int D, int chkNum) {
        // 현재 좌표에 벽이 없는 경우
        while (map[y][x] != 6) {
            // 주어진 방향으로 이동하기 위해 좌표를 계산
            y = y + dy[D];
            x = x + dx[D];

            if (y < 0 || y >= N || x < 0 || x >= M) break;
            else {
                if (map[y][x] == 0) {
                    map[y][x] = chkNum;
                }
                // 방향을 바꿔가면서 감시 가능한 곳을 체크하고 있으므로 체크한 곳 해제를 위해 사용
                // CCTV가 서로 중복해서 감시 가능한 곳이 있을 것이기 떄문에
                // 본인이 감시한 곳만 해제하기 위해 고유감시번호로 확인합니다.
                else if (map[y][x] == chkNum) {
                    map[y][x] = 0;
                }
            }
        }
    }
}
