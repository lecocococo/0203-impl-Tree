package impl_tree_0203;

public class ArrBinaryTree implements Tree{
    private static final int INIT = 15;
    private int[] array;
    private int size;
    private int capacity;

    public ArrBinaryTree() {
        this.array = new int[INIT];
        array[1] = 1; // 루트 설정
        this.size = 1;
        this.capacity = INIT;
    }


    @Override
    public void appendChild(int parent, int val, boolean position) {
        int childPos = parent*2;
        if(position == false) {
            childPos += 1;
        }

        if(childPos >= capacity) {
            increaseCapacity();
        }

        array[childPos] = val;
        size++;
    }

    private void increaseCapacity() {
        int[] temp = new int[(int) (capacity*2)];
        System.arraycopy(array, 0, temp, 0, capacity);
        capacity *= 2;
        array = temp;
    }

    @Override
    public void preOrder() {
        recurPreOrder(1);
    }

    public void recurPreOrder(int nodeNum) {
        if (!check(nodeNum) || nodeNum == 0 || array[nodeNum]==0) {
            return;
        }
        System.out.print(array[nodeNum] + " ");
        recurPreOrder(nodeNum * 2);
        recurPreOrder(nodeNum * 2 + 1);
    }

    @Override
    public void inOrder() {
        recurInOrder(1);
    }

    public void recurInOrder(int nodeNum) {
        if (!check(nodeNum) || nodeNum == 0 || array[nodeNum]==0) {
            return;
        }
        recurInOrder(nodeNum * 2);
        System.out.print(array[nodeNum] + " ");
        recurInOrder(nodeNum * 2 + 1);
    }

    @Override
    public void postOrder() {
        recurPostOrder(1);
    }

    public void recurPostOrder(int nodeNum) {
        if (!check(nodeNum) || nodeNum == 0 || array[nodeNum]==0) {
            return;
        }
        recurPostOrder(nodeNum * 2);
        recurPostOrder(nodeNum * 2 + 1);
        System.out.print(array[nodeNum] + " ");
    }

    private boolean check(int nodeNum) {
        if(capacity <= nodeNum) {
            return false;
        }
        return true;
    }
}
