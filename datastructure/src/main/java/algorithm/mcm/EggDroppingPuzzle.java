package algorithm.mcm;

public class EggDroppingPuzzle {

    public static void main(String[] args) {
        System.out.println(findFloor(2, 10)); //output : 4
    }

    private static int findFloor(int eggs, int floors) {

        if (floors == 0 || floors == 1) {
            return floors;
        }

        if (eggs == 1) {
            return floors;
        }

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= floors; k++) {
            int res = Math.max(findFloor(eggs - 1, k - 1), findFloor(eggs, floors - k));
            min = Math.min(res, min);
        }
        return min + 1;
    }


}
