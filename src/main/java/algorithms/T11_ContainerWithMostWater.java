package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2018/12/18
 */
public class T11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));

    }

    static int maxArea(int[] height) {
        int max = 0;
        int p = 0;
        int q = height.length - 1;
        while (p < q) {
            int area = getArea(height, p, q);
            max = Math.max(max, area);
            if (height[p] < height[q]) {
                p++;
            } else {
                q--;
            }
        }
        return max;
    }

    static int getArea(int[] a, int p, int q) {
        return Math.min(a[q], a[p]) * (q - p);
    }

}
