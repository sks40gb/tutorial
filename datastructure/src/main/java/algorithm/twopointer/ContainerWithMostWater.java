package algorithm.twopointer;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater o = new ContainerWithMostWater();
        System.out.println(o.maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int i = 0;
        int j = 0;
        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
                i = left;
                j = right;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
