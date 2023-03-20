package impl_tree_0203;

import impl_tree_0203.exception.MyNoSuchElementException;

import java.util.ArrayDeque;
import java.util.Queue;

public class LinkedListBinaryTree  implements Tree{
    private Node root;
    private int size;

    static class Node {
        Node left;
        int val;
        Node right;

        public Node(int val) {
            this.left = null;
            this.val = val;
            this.right = null;
        }
    }

    public LinkedListBinaryTree() {
        this.root = new Node(1);
        this.size = 1;
    }

    @Override
    public void appendChild(int parent, int value, boolean position) {
        insert(parent, value, position);
    }

    private void insert(int parent, int value, boolean position) {
        // 레벨 순회로 찾아서 넣어준다.
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.val == parent) {
                if (!position && node.right == null) {
                    node.right = new Node(value);
                    //System.out.println("parent " + node.val + " right: " + node.right.val);
                    return;
                } else if (position && node.left == null) {
                    node.left = new Node(value);
                    //System.out.println("parent " + node.val + " left: " + node.left.val);
                    return;
                } else {
                    throw new MyNoSuchElementException("해당하는 부모가 없습니다!!!");
                }
            }
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }

    @Override
    public void preOrder() {
        recurPreOrder(root);
    }
    public void recurPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        recurPreOrder(node.left);
        recurPreOrder(node.right);
    }

    @Override
    public void inOrder() {
        recurInOrder(root);
    }
    public void recurInOrder(Node node) {
        if (node == null) {
            return;
        }
        recurInOrder(node.left);
        System.out.print(node.val + " ");
        recurInOrder(node.right);
    }
    @Override
    public void postOrder() {
        recurPostOrder(root);
    }
    public void recurPostOrder(Node node) {
        if (node == null) {
            return;
        }
        recurPostOrder(node.left);
        recurPostOrder(node.right);
        System.out.print(node.val + " ");
    }
}
