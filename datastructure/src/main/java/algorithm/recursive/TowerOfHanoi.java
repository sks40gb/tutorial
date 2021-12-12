package algorithm.recursive;

public class TowerOfHanoi {

    public static void main(String[] s) {
        int n = 4; // Number of disks
        towerOfHanoi('A', 'C', 'B', n); // A, B and C are names of rods
    }

    public static void towerOfHanoi(char source, char destination, char helper, int k) {
        if (k == 1) {
            System.out.println("Moving " + k + " from " + source + " to " + destination);
            return;
        }

        towerOfHanoi(source, helper, destination, k - 1);
        System.out.println("Moving " + k + " from " + source + " to " + destination);
        towerOfHanoi(helper, destination, source, k - 1);
    }

}
