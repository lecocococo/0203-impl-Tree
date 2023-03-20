package impl_tree_0203.exception;

public class MyNoSuchElementException extends RuntimeException{
    public MyNoSuchElementException() {
        this("잘못된 값입니다.");
    }
    public MyNoSuchElementException(String msg) {
        super(msg);
    }
}
