package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2019/1/9
 */
public class Maximizesumdistanceforintegerarray {
    public static void main(String[] args) {
        Maximizesumdistanceforintegerarray maximizesumdistanceforintegerarray = new Maximizesumdistanceforintegerarray();
//        int[] a =  {8, 2, 4, 9, 5, 8, 0, 3, 8, 2};
        int[] a =  {-8,4,0,5,-3,6};
        System.out.println(maximizesumdistanceforintegerarray.solution(a));
    }

    public int solution(int[] a) {
        int[] Ai = new int[a.length];
        int[] Aj = new int[a.length];
        int maxi = a[0];
        int maxj = a[0];
        for (int i = 0; i < a.length; i++) {
            maxi = Math.max(maxi, a[i] + i);
            maxj = Math.max(maxj, a[i] - i);
        }
        return maxi+maxj;
    }
}
