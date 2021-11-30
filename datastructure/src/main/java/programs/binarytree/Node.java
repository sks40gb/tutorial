package programs.binarytree;

/**
 *
 * @author sunsingh
 */
public class Node<T> {

    public Node(T value) {
        this.data = value;
    }
    T data;
    public Node<T> left;
    public Node<T> right;

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
    
    public boolean isLeaf(){
        return left == null && right == null;
    }

}
