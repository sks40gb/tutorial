package algorithm.recursive;

/**
 * https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
 * 
 * Tower of Hanoi is a mathematical puzzle where we have three rods and n disks.
 * The objective of the puzzle is to move the entire stack to another rod,
 * obeying the following simple rules:
 * 
 * Only one disk can be moved at a time.
 * Each move consists of taking the upper disk from one of the stacks and
 * placing it on top of another stack i.e. a disk can only be moved if it is the
 * uppermost disk on a stack.
 * No disk may be placed on top of a smaller disk.
 * 
 */
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
