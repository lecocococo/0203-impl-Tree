package impl_tree_0203;

public interface Tree {

    void appendChild(int parent, int value, boolean position);
    void preOrder();
    void inOrder();
    void postOrder();

}
