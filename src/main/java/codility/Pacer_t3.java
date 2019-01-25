package codility;

/**
 * @author Nova wangxingchen
 * @date 2019/1/9
 */
public class Pacer_t3 {
    public static void main(String[] args) {
        Pacer_t3 pacer_t3 = new Pacer_t3();
//        int[] a = {2, 8, 4, 3, 2};
//        System.out.println(pacer_t3.solution(a, 7, 11, 3));

        int[] a = {5};
        System.out.println(pacer_t3.solution(a, 4, 0, 3));
    }

    public int solution(int[] A, int X, int Y, int Z) {
        int time = 0;
        boolean lockX = false;
        boolean lockY = false;
        boolean lockZ = false;
        int[] helper = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < A.length; i++) {
            //进站
            int count = 0;
            if (i < A.length && X >= A[i] && !lockX) {
                lockX = true;
                helper[0] = A[i];
                i++;
                count++;
            } else if (i < A.length && Y >= A[i] && !lockY) {
                lockY = true;
                helper[1] = A[i];
                i++;
                count++;
            } else if (i < A.length && Z >= A[i] && !lockZ) {
                lockZ = true;
                helper[2] = A[i];
                i++;
                count++;
            }
            //消费
            //进不去
            if (count == 0) {
                return -1;
            } else {
                //查找最先出站的
                int p = getMinIndex(helper);
                int val = helper[p];
                time += val;

                if (helper[0] != Integer.MAX_VALUE) {
                    X -= val;
                }
                if (helper[1] != Integer.MAX_VALUE) {
                    Y -= val;
                }
                if (helper[2] != Integer.MAX_VALUE) {
                    Z -= val;
                }
                if (p == 0) {
                    lockX = false;
                } else if (p == 1) {
                    lockY = false;
                } else if (p == 2) {
                    lockZ = false;
                }
            }
        }
        return time;
    }

    public static int getMinIndex(int[] a) {
        int p = 0;
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                p = i;
            }
        }
        return p;
    }
}
