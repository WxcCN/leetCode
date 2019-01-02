package algorithm;

/**
 * @author Nova wangxingchen
 * @date 2018/12/26
 * 八皇后问题-回溯
 */
public class EeightQueen {

    public static void main(String[] args) {
        solution();

    }

    public static int[] solution() {
        int[] res = new int[8];
        call8queens(res,0);
        return res;
    }

    private static void call8queens(int[] res, int row) {
        if (row == 8) {
            printQ(res);
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (isOk(row, i,res)) {
                res[row] = i;
                call8queens(res,row+1);
            }
        }
    }

    private static boolean isOk(int row, int i ,int[] res) {
//        i为列
        int l = i - 1;
        int r = i + 1;
        for (int j = row - 1 ; j >= 0 ; j--) {
            if (l >=0 && res[j]==l--) return false;
            if (res[j] == i) return false;
            if (r<8 && res[j]==r++) return false;
        }
        return true;
    }

    private static void printQ(int[] res) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (res[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
