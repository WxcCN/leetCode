package codility;

/**
 * @author Nova wangxingchen
 * @date 2019/1/9
 */
public class Pacer_t1 {
    public static void main(String[] args) {
        Pacer_t1 pacer_t1 = new Pacer_t1();
        int a = 15603;
        System.out.println(pacer_t1.solution(a));
    }
    public int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < (1 + l); ++p) {
            int i;
            boolean ok = true;
            for (i = l - 1; i > p; --i) {
                if (d[i] != d[i - p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }
}
